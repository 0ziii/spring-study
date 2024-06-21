package com.oziii.store.domain.vote;

import lombok.Getter;

@Getter
public class VoteItem {
    private Long voteItemId;
    private String title;

    public VoteItem(String title) {
        this.title = title;
    }

    public VoteItem(Long voteItemId, String title) {
        this.voteItemId = voteItemId;
        this.title = title;
    }
}
