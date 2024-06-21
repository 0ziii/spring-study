package com.oziii.store.api.dto.vote;

import com.oziii.store.domain.vote.Vote;

import java.util.List;
import java.util.stream.Collectors;

public record VoteResponse(
        Long voteId,
        String title,
        boolean isEnabled,
        List<VoteItemResponse> voteItems
) {
    public static VoteResponse fromDomain(final Vote vote) {
        return new VoteResponse(vote.getVoteId(), vote.getTitle(), vote.isEnabled(), vote.getVoteItems().stream()
                .map(VoteItemResponse::fromDomain).collect(Collectors.toList()));
    }
}
