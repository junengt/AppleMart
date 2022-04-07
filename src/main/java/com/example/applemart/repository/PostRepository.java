package com.example.applemart.repository;

import com.example.applemart.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.deleted = false")
    List<Post> findAll();

    @Query("SELECT p FROM Post p WHERE p.deleted = false AND p.title LIKE %:searchKeyword%")
    List<Post> findPostsBySearch(String searchKeyword);

    @Modifying
    @Query("UPDATE Post p SET p.deleted = true WHERE p.id = :postId")
    void updatePostDelete(@Param("postId") Long postId);
}

