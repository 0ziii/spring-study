package com.oziii.store.jpa.mapper.vote;

import com.oziii.store.domain.vote.VoteCount;
import com.oziii.store.jpa.entity.vote.VoteCountId;

public class VoteCountMapper {
    public VoteCountMapper(){}

    public static VoteCountId toJpaEntityId(final VoteCount voteCount) {
        return new VoteCountId(voteCount.getVoteId(), voteCount.getVoteItemId());
    }
}
