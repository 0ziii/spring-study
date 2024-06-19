package com.oziii.store.api.vote.controller;

import com.oziii.store.api.vote.dto.PerformVoteRequest;
import com.oziii.store.api.vote.dto.VoteRequest;
import com.oziii.store.api.vote.dto.VoteResponse;
import com.oziii.store.api.vote.facade.VoteFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteFacade voteFacade;

    /**
     * 투표 생성
     */

    @PostMapping("/save")
    public ResponseEntity<VoteResponse> createVote(@RequestBody VoteRequest voteRequest) {
        return null;
    }

    /**
     * 투표 삭제
     */
    @PutMapping("/delete")
    public ResponseEntity deleteVote(@RequestParam Long voteId) {
        return ResponseEntity.ok().build();
    }

    /**
     * 투표 조회
     */
    @GetMapping("/{voteId}")
    public ResponseEntity<VoteResponse> getVoteByVoteId(@PathVariable Long voteId) {
        return null;
    }

    /**
     * 전체 투표 조회
     */
    @GetMapping("/all")
    public ResponseEntity<List<VoteResponse>> getVotes() {
        return null;
    }

    /**
     * 투표하기
     */
    @PostMapping()
    public ResponseEntity performVote(@RequestBody PerformVoteRequest performVoteRequest) {
        return ResponseEntity.ok().build();
    }

}
