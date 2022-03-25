package com.example.applemart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_name", nullable = false )
    private String name;

    @Column(name = "user_town", nullable = false)
    private Long userTownCode;

    @Column(name = "user_photo_path")
    private String photo;

    @Column(name = "user_created_at", nullable = false)
    private LocalDateTime createdTime;

    @Column(name = "user_updated_at", nullable = false)
    private LocalDateTime updatedTime;

    @Column(name = "user_deleted_yn")
    private boolean deleted = false;

    @Column(name = "user_manner")
    private double manners = 36.5;

    @Column(name = "user_trade_rate")
    private double tradeRate;

    @Column(name = "user_response_at")
    private double responseRate;

    @OneToMany(mappedBy = "user") //양방향 연관관계로 설계
    private List<Post> posts = new ArrayList<>();
}
