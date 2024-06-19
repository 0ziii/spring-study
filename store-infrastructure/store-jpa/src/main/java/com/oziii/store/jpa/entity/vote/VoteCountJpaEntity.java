package com.oziii.store.jpa.entity.vote;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vote_count")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VoteCountJpaEntity {

    @EmbeddedId
    private VoteCountId voteCountId;

    @Column(name = "count")
    private int count;

    @Version
    @Column(name = "version")
    private int version;

}
