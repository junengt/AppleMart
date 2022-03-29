package com.example.applemart.domain;

import com.example.applemart.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "notice")
public class Notice extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @Column(name = "notice_title")
    private String title;

    @Column(name = "notice_content")
    private String content;

}
