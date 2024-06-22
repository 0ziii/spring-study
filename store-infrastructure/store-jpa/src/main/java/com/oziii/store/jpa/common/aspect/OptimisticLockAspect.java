package com.oziii.store.jpa.common.aspect;

import com.oziii.store.jpa.common.annotation.RetryOptimisticLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import jakarta.persistence.OptimisticLockException;

import java.lang.reflect.Method;


@Slf4j
@Aspect
@Component
public class OptimisticLockAspect {

    @Around("@annotation(com.oziii.store.jpa.common.annotation.RetryOptimisticLock)")
    public Object retry(final ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RetryOptimisticLock annotation = method.getAnnotation(RetryOptimisticLock.class);

        int retryCount = 0;
        while (retryCount < annotation.count()) {
            try {
                return joinPoint.proceed(); // 메서드 실행
            } catch (OptimisticLockException | ObjectOptimisticLockingFailureException e) {
                retryCount++;
                Thread.sleep(annotation.waitTime());
            }
            log.info("OptimisticLockAspect 재시도");
        }
        log.error("OptimisticLockAspect 재시도 실패");
        throw new RuntimeException(joinPoint.proceed().toString()+ " 에서 예외 발생");
    }
}
