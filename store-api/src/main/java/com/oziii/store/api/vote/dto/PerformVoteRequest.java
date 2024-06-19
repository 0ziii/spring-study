package com.oziii.store.api.vote.dto;

public record PerformVoteRequest(
        Long voteId,
        Long voteItemId
) {
}
