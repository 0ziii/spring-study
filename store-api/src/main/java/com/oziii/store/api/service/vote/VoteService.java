package com.oziii.store.api.service.vote;

import com.oziii.store.api.dto.vote.VoteRequest;
import com.oziii.store.api.dto.vote.VoteResponse;
import com.oziii.store.domain.vote.Vote;
import com.oziii.store.jpa.repository.vote.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteResponse createVote(VoteRequest voteRequest) {
        Vote vote = voteRepository.save(voteRequest.toDomain());
        return VoteResponse.fromDomain(vote);
    }

    public void deletedVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }

    public VoteResponse getVoteByVoteId(Long voteId) {
        Vote vote = voteRepository.findById(voteId);
        return VoteResponse.fromDomain(vote);
    }

    public List<VoteResponse> getVotes() {
        List<Vote> votes = voteRepository.findAll();
        return votes.stream()
                .map(VoteResponse::fromDomain).collect(Collectors.toList());
    }
}
