package com.oziii.store.api.dto.vote;

import com.oziii.store.domain.vote.VoteCount;

public record PerformVoteRequest(
        Long voteId,
        Long voteItemId
) {
    public VoteCount toDomain() {
        return new VoteCount(voteId, voteItemId);
    }
}
