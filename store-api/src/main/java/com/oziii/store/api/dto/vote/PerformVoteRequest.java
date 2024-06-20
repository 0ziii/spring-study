package com.oziii.store.api.dto.vote;

public record PerformVoteRequest(
        Long voteId,
        Long voteItemId
) {
}
