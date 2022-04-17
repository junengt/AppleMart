package com.example.applemart.repository;

import com.example.applemart.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

}

