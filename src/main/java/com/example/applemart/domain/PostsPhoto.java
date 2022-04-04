package com.example.applemart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@Table(name = "posts_photo")
public class PostsPhoto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_photo_id")
    private Long id;

    @Column(name = "posts_photo_path")
    private String photoPath;

    @ManyToOne(fetch = LAZY) //단방향 연관관계로 설계
    @JoinColumn(name = "posts_id")
    private Post post;

}
