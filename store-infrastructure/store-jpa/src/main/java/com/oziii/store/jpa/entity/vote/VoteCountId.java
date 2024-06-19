package com.oziii.store.jpa.entity.vote;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VoteCountId implements Serializable {

    @Column(name = "vote_id")
    private Long voteId;

    @Column(name = "vote_item_id")
    private Long voteItemId;
}
