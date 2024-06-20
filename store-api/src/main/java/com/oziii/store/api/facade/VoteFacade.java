package com.oziii.store.api.facade;

import com.oziii.store.api.dto.vote.PerformVoteRequest;
import com.oziii.store.api.dto.vote.VoteRequest;
import com.oziii.store.api.dto.vote.VoteResponse;
import com.oziii.store.api.service.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class VoteFacade {

    private final VoteService voteService;

    public VoteResponse createVote(VoteRequest voteRequest) {
        return voteService.createVote(voteRequest);
    }

    public void deleteVote(Long voteId) {
        voteService.deletedVote(voteId);
    }

    public VoteResponse getVoteById(Long voteId) {
        return voteService.getVoteByVoteId(voteId);
    }

    public List<VoteResponse> getVotes() {
        return voteService.getVotes();
    }

    public void performVote(PerformVoteRequest performVoteRequest) {
        voteService.performVote(performVoteRequest);
    }
}
