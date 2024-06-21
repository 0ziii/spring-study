package com.oziii.store.jpa.mapper.vote;

import com.oziii.store.domain.vote.VoteItem;
import com.oziii.store.jpa.entity.vote.VoteItemJpaEntity;

public class VoteItemMapper {
    public VoteItemMapper(){}

    public static VoteItemJpaEntity toJpaEntity(final VoteItem voteItem) {
        return new VoteItemJpaEntity(voteItem.getTitle());
    }

    public static VoteItem toDomain(final VoteItemJpaEntity voteItemJpaEntity) {
        return new VoteItem(voteItemJpaEntity.getVoteItemId(), voteItemJpaEntity.getTitle());
    }
}
