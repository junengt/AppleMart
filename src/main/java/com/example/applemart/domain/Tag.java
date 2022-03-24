package com.example.applemart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "tag")
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag_name")
    private String name; //열거형으로 태그 이름을 나열하려면 enum 클래스 구현해야함

    @Column(name = "tag_seq")
    private int seq; //태그 정렬 순서로 시퀀스 값
}
