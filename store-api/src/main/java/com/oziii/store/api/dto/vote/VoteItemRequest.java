package com.oziii.store.api.dto.vote;

import com.oziii.store.domain.vote.VoteItem;

public record VoteItemRequest(
        String title
) {
    public VoteItem toDomain() {
        return new VoteItem(title);
    }
}
