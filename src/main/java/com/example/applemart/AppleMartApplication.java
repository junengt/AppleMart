package com.example.applemart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppleMartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppleMartApplication.class, args);
    }

}
