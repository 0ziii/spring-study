package com.oziii.store.jpa.entity.vote;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "vote")
public class VoteJpaEntity {

    @Id
    @Column(name = "vote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @Column(name = "title")
    private String title;

    @Column(name = "enabled")
    private boolean isEnabled;

    @OneToMany(mappedBy = "vote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoteItemJpaEntity> voteItems = new ArrayList<>();

}
