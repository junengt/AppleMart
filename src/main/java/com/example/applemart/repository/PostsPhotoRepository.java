package com.example.applemart.repository;

import com.example.applemart.domain.PostsPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsPhotoRepository extends JpaRepository<PostsPhoto, Long> {
}
