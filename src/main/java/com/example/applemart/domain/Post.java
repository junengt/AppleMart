package com.example.applemart.domain;

import com.example.applemart.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "posts")
@Getter @Setter
public class Post extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    private Long id;

    @Column(name = "posts_title")
    private String title;

    @Column(name = "posts_price")
    private int price;

    @Column(name = "posts_content")
    private String content;

    @Column(name = "posts_delete_yn")
    private boolean deleted;

    @Column(name = "posts_status")
    private boolean status; //열거형으로 설계시 enum으로 수정 필요

    @Column(name = "posts_town")
    private Long postTownCode;

    @ManyToOne(fetch = LAZY) //양방향 연관관계로 설계함
    @JoinColumn(name = "user_id")
    private User user;

}
