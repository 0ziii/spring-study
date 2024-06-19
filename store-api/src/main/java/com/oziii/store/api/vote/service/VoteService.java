package com.oziii.store.api.vote.service;

import com.oziii.store.api.vote.dto.VoteRequest;
import com.oziii.store.api.vote.dto.VoteResponse;
import com.oziii.store.jpa.repository.vote.VoteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteJpaRepository voteJpaRepository;

    public VoteResponse createVote(VoteRequest voteRequest) {
        return null;
    }
}
