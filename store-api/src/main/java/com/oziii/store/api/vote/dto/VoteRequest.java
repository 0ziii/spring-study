package com.oziii.store.api.vote.dto;

import java.util.List;

public record VoteRequest(
        String title,
        List<VoteItemRequest> voteItems
) {
}
