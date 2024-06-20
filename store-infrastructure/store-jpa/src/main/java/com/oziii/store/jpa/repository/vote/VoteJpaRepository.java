package com.oziii.store.jpa.repository.vote;

import com.oziii.store.jpa.entity.vote.VoteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteJpaRepository extends JpaRepository<VoteJpaEntity, Long> {
    List<VoteJpaEntity> findAllByEnabled(boolean isEnabled);
}
