package com.oziii.store.jpa.repository.vote;

import com.oziii.store.domain.vote.VoteCount;
import com.oziii.store.jpa.entity.vote.VoteCountJpaEntity;
import com.oziii.store.jpa.mapper.vote.VoteCountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Repository
@Transactional
@RequiredArgsConstructor
public class VoteCountRepository {

    private final VoteCountJpaRepository voteCountJpaRepository;

    public void save(VoteCount voteCount) {
        voteCountJpaRepository.save(VoteCountMapper.toJpaEntity(voteCount));
    }
    public void updateCount(VoteCount voteCount) {
        /**
         * 별도의 @Lock 명시가 없으면 default 타입으로 Optimistic 적용
         */
        VoteCountJpaEntity voteCountJpaEntity = voteCountJpaRepository.findById(VoteCountMapper.toJpaEntityId(voteCount))
                .orElseThrow(NoSuchElementException::new);
        voteCountJpaEntity.increaseCount();
        /**
         * flush 되는 시점에 version 확인 후 충돌시 OptimisticLockException 발생
         */
        voteCountJpaRepository.save(voteCountJpaEntity);
    }
}
