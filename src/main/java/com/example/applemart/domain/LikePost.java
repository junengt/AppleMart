package com.example.applemart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@Table(name = "like+posts")
public class LikePost {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = LAZY) //단방향 연관관계 설계
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY) //단방향 연관관계 설계
    @JoinColumn(name = "posts_id")
    private Post post;
}
