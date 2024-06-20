package com.oziii.store.api.dto.vote;

import com.oziii.store.domain.vote.Vote;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public record VoteRequest(
        String title,
        boolean isEnabled,
        List<VoteItemRequest> voteItems
) {

    public Vote toDomain() {
        return new Vote(title, isEnabled, voteItems.stream()
                .map(VoteItemRequest::toDomain).collect(Collectors.toList()));
    }
}
