package com.oziii.store.jpa.repository.vote;

import com.oziii.store.jpa.entity.vote.VoteCountId;
import com.oziii.store.jpa.entity.vote.VoteCountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteCountJpaRepository extends JpaRepository<VoteCountJpaEntity, VoteCountId> {
}
