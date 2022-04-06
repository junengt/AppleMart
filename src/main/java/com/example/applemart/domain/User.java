package com.example.applemart.domain;

import com.example.applemart.common.BaseEntity;
import com.example.applemart.converter.BooleanToYNConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")//h2 DB에선 USER가 예약어이므로 users로 설정 나중에 user로 바꿔야함
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "firebase_uid", nullable = false)
    private String phoneNumber;

//    @Column(name = "user_name", nullable = false )
//    private String name;

//    @Column(name = "user_town", nullable = false)
//    private Long userTownCode;

    @Column(name = "user_photo_path")
    private String photo;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "user_deleted_yn")
    private boolean deleted = false;

    @Column(name = "user_manner")
    private double manners = 36.5;

    @Column(name = "user_trade_rate")
    private double tradeRate = 100.0;

    @Column(name = "user_response_at")
    private double responseRate = 100.0;

    @OneToMany(mappedBy = "user") //양방향 연관관계로 설계
    private List<Post> posts = new ArrayList<>();
}
