package com.oziii.store.api.vote.dto;

import java.util.List;

public record VoteResponse(
        Long voteId,
        String title,
        boolean isEnabled,
        List<VoteItemResponse> voteItems
) {

}
