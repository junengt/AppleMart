package com.example.applemart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@Table(name = "pay")
public class Pay {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pay_id")
    private Long id;

    @ManyToOne(fetch = LAZY) //단방향 연관관계
    @JoinColumn(name = "user_id")
    private User user;

    private Long account;
}
