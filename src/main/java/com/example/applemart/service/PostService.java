package com.example.applemart.service;

import com.example.applemart.api.PostApiController;
import com.example.applemart.domain.*;
import com.example.applemart.repository.PostRepository;
import com.example.applemart.repository.PostTagRepository;
import com.example.applemart.repository.PostsPhotoRepository;
import com.example.applemart.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostsPhotoRepository postsPhotoRepository;
    private final PostTagRepository postTagRepository;

    @Transactional(readOnly = true)
    public List<PostListDto> findPosts() {
        return postRepository.findAll().stream()
                .map(p -> new PostListDto(p.getId(), p.getTitle(), p.getPrice(), p.getContent()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostListDto> findPostsBySearchKeyword(String searchKeyword) {
        return postRepository.findPostsBySearch(searchKeyword).stream()
                .map(p -> new PostListDto(p.getId(), p.getTitle(), p.getPrice(), p.getContent()))
                .collect(Collectors.toList());
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).get();
        postRepository.updatePostDelete(post.getId());
    }

    static class PostsPhotoDto {
        private String photoPath;
        private MultipartFile image;
        private Post post;
    }

    @Data
    @AllArgsConstructor
    public class PostListDto {
        private Long id;
        private String title;
        private int price;
        private String content;
    }

    public Long postSave(Long userId, RequestPostForm form) {
        Optional<User> user = userRepository.findById(userId);
        Post post = new Post();
        post.setUser(user.get());
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        postRepository.save(post);
        return post.getId();
    }

    public void savePostImages(Long postId, List<MultipartFile> fileList) {
        if (CollectionUtils.isEmpty(fileList)) {
            return;
        }
        Post post = postRepository.findById(postId).get();
        //.get ?????? .orElseThrow ???????????? ?????? ??????
        for (MultipartFile file : fileList) {
            // ????????? ???????????? ???????????? ????????? ?????? ??????(?????? ????????? ????????? ????????? ??????)
            String filePath = "C:\\Users\\kaas1\\Downloads\\" + file.getOriginalFilename();
            // filePath ????????? ??????
            PostsPhoto postsPhoto = PostsPhoto.builder().photoPath(filePath).post(post).build();

            // ????????? ?????? ???????????? ??????
            try {
                Files.copy(file.getInputStream(), Path.of(filePath), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println(e);
            }
            // ?????? ?????? ???
            postsPhotoRepository.save(postsPhoto);
        }
    }

    public void savePostTag(Long postId) {

        Post post = postRepository.findById(postId).get();
    }


    @Data
    public class RequestPostForm {
//        private List<PostsPhotoDto> postsPhotoDtos;
        private String title;
        private List<PostTag> postTags;
        private int price;
        private String content;
    }
}
