package com.oziii.store.jpa.entity.vote;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "vote_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VoteItemJpaEntity {

    @Id
    @Column(name = "vote_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteItemId;

    @Column(name = "title")
    private String title;

    @ManyToOne //mappedBy 가 없으므로 해당 객체가 연관관계의 주인이 된다 -> 보통 N쪽이 외래키 + 주인임
    @JoinColumn(name = "vote_id") //데이터베이스 테이블에서 사용될 외래키
    private VoteJpaEntity vote;

    public VoteItemJpaEntity(String title) {
        this.title = title;
    }

    public void setVote(VoteJpaEntity vote) {
        this.vote = vote;
    }
}
