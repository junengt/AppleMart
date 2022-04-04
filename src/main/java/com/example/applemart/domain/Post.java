package com.example.applemart.domain;

import com.example.applemart.common.BaseEntity;
import com.example.applemart.converter.BooleanToYNConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "posts")
@Getter @Setter
public class Post extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    private Long id;


    @ManyToOne(fetch = LAZY) //양방향 연관관계로 설계함
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "posts_title")
    private String title;

    @Column(name = "posts_price")
    private int price;

    @Column(name = "posts_content")
    private String content;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "posts_delete_yn")
    private boolean deleted = false;

    @Column(name = "posts_status")
    private boolean status = true; //true : 판매 중 / false : 판매 완료

//    @Column(name = "posts_town")
//    private Long postTownCode;

}
