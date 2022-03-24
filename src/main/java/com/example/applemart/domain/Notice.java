package com.example.applemart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Notice {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    private Long id;

    @Column(name = "notice_title")
    private String title;

    @Column(name = "notice_content")
    private String content;

    @Column(name = "notice_created_at")
    private LocalDateTime createdTime;

    @Column(name = "notice_updated_at")
    private LocalDateTime updatedTime;
}
