package com.example.applemart.repository;

import com.example.applemart.domain.Post;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> findAll();
    List<Post> findPostsBySearch(String searchKeyword);
    void updatePostDelete(@Param("postId") Long postId);
}
