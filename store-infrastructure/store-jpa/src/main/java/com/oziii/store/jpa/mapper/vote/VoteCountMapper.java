package com.oziii.store.jpa.mapper.vote;

import com.oziii.store.domain.vote.VoteCount;
import com.oziii.store.jpa.entity.vote.VoteCountId;
import com.oziii.store.jpa.entity.vote.VoteCountJpaEntity;

public class VoteCountMapper {
    public VoteCountMapper(){}

    public static VoteCountJpaEntity toJpaEntity(final VoteCount voteCount) {
        return new VoteCountJpaEntity(toJpaEntityId(voteCount));
    }

    public static VoteCountId toJpaEntityId(final VoteCount voteCount) {
        return new VoteCountId(voteCount.getVoteId(), voteCount.getVoteItemId());
    }

    public static VoteCount toDomain(final VoteCountJpaEntity voteCountJpaEntity) {
        VoteCountId voteCountId = voteCountJpaEntity.getVoteCountId();
        return new VoteCount(voteCountId.getVoteId(), voteCountId.getVoteItemId());
    }
}
