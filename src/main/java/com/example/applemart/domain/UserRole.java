//package com.example.applemart.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//import static javax.persistence.FetchType.*;
//
//@Entity
//@Getter @Setter
//@Table(name = "user_role")
//public class UserRole {
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_role_id")
//    private Long id;
//
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "role_id")
//    private Role role;
//}
