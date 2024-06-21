package com.oziii.store.jpa.mapper.vote;

import com.oziii.store.domain.vote.Vote;
import com.oziii.store.jpa.entity.vote.VoteJpaEntity;

import java.util.stream.Collectors;

public class VoteMapper {
    public VoteMapper() {}

    public static VoteJpaEntity toJpaEntity(final Vote vote) {
        return new VoteJpaEntity(vote.getTitle(), vote.isEnabled());
    }

    public static Vote toDomain(final VoteJpaEntity voteJpaEntity) {
        return new Vote(voteJpaEntity.getVoteId(), voteJpaEntity.getTitle(), voteJpaEntity.isEnabled(), voteJpaEntity.getVoteItems().stream()
                .map(VoteItemMapper::toDomain).collect(Collectors.toList()));
    }
}
