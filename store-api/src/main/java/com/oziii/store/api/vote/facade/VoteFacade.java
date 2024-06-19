package com.oziii.store.api.vote.facade;

import com.oziii.store.api.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VoteFacade {

    private final VoteService voteService;

}
