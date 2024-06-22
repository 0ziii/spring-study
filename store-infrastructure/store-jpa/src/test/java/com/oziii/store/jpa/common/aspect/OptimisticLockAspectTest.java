package com.oziii.store.jpa.common.aspect;
import com.oziii.store.jpa.common.annotation.RetryOptimisticLock;
import java.lang.reflect.Method;

import jakarta.persistence.OptimisticLockException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OptimisticLockAspectTest {

    @InjectMocks
    private OptimisticLockAspect optimisticLockAspect;

    @Mock
    private ProceedingJoinPoint proceedingJoinPoint;

    @Test
    public void testRetryAspect() throws Throwable {
        // Given
        MethodSignature methodSignature = mock(MethodSignature.class);
        Method method = TestService.class.getMethod("optimisticTest");

        // When
        when(proceedingJoinPoint.getSignature()).thenReturn(methodSignature);
        when(methodSignature.getMethod()).thenReturn(method);
        when(proceedingJoinPoint.proceed()).thenReturn("TestSuccess");

        Object result = optimisticLockAspect.retry(proceedingJoinPoint);

        // Then
        verify(proceedingJoinPoint, times(1)).proceed(); // joinPoint.proceed()가 한 번 호출되어야 함
        assertEquals("TestSuccess", result); // 결과 확인

    }

    @Test
    public void testRetryAspect_ThrowsException() throws Throwable {
        // Given
        MethodSignature methodSignature = mock(MethodSignature.class);
        Method method = TestService.class.getMethod("optimisticTest");

        // When
        when(proceedingJoinPoint.getSignature()).thenReturn(methodSignature);
        when(methodSignature.getMethod()).thenReturn(method);
        when(proceedingJoinPoint.proceed()).thenThrow(new OptimisticLockException());

        // Then
        assertThrows(OptimisticLockException.class, () -> optimisticLockAspect.retry(proceedingJoinPoint));
        verify(proceedingJoinPoint, times(3)).proceed();
    }

    static class TestService {
        @RetryOptimisticLock(count = 2, waitTime = 1000L)
        public void optimisticTest() {
        }
    }
}