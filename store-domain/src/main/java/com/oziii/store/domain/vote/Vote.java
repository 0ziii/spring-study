package com.oziii.store.domain.vote;

import java.util.List;

public class Vote {
    private Long voteId;
    private String title;
    private boolean isEnabled;
    private List<VoteItem> voteItems;

    public Vote(String title, boolean isEnabled, List<VoteItem> voteItems) {
        this.title = title;
        this.isEnabled = isEnabled;
        this.voteItems = voteItems;
    }
}
