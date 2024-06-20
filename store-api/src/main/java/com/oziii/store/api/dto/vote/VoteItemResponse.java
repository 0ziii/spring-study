package com.oziii.store.api.dto.vote;

import com.oziii.store.domain.vote.VoteItem;

public record VoteItemResponse(
        Long voteItemId,
        String title
) {
    public static VoteItemResponse fromDomain(final VoteItem voteItem) {
        return new VoteItemResponse(voteItem.getVoteItemId(), voteItem.getTitle());
    }
}
