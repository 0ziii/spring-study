package com.oziii.store.jpa.repository.vote;

import com.oziii.store.jpa.entity.vote.VoteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteJpaRepository extends JpaRepository<VoteJpaEntity, Long> {
}
