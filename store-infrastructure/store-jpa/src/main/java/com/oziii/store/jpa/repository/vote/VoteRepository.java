package com.oziii.store.jpa.repository.vote;

import com.oziii.store.domain.vote.Vote;
import com.oziii.store.jpa.entity.vote.VoteItemJpaEntity;
import com.oziii.store.jpa.entity.vote.VoteJpaEntity;
import com.oziii.store.jpa.mapper.vote.VoteItemMapper;
import com.oziii.store.jpa.mapper.vote.VoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
public class VoteRepository {

    private static final boolean TRUE = true;
    private final VoteJpaRepository voteJpaRepository;

    public Vote save(Vote vote) {
        VoteJpaEntity voteJpaEntity = VoteMapper.toJpaEntity(vote);
        List<VoteItemJpaEntity> voteItemJpaEntityList = vote.getVoteItems().stream()
                .map(VoteItemMapper::toJpaEntity).toList();
        voteItemJpaEntityList.forEach(voteJpaEntity::addVoteItem);
        return VoteMapper.toDomain(voteJpaRepository.save(voteJpaEntity));
    }

    public void deleteById(Long voteId) {
        VoteJpaEntity voteJpaEntity = voteJpaRepository.findById(voteId).orElseThrow(NoSuchElementException::new);
        voteJpaRepository.delete(voteJpaEntity);
    }

    public Vote findById(Long voteId) {
        return VoteMapper.toDomain(voteJpaRepository.findById(voteId).orElseThrow(NoSuchElementException::new));
    }

    public List<Vote> findAll() {
        List<VoteJpaEntity> voteJpaEntities = voteJpaRepository.findAllByIsEnabled(TRUE);
        return voteJpaEntities.stream()
                .map(VoteMapper::toDomain).collect(Collectors.toList());
    }
}
