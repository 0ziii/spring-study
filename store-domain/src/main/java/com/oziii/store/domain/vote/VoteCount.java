package com.oziii.store.domain.vote;

import lombok.Getter;

@Getter
public class VoteCount {
    private Long voteId;
    private Long voteItemId;
    private int count;

    public VoteCount(Long voteId, Long voteItemId) {
        this.voteId = voteId;
        this.voteItemId = voteItemId;
    }
}
