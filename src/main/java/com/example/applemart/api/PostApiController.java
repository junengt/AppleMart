package com.example.applemart.api;

import com.example.applemart.domain.Post;
import com.example.applemart.domain.PostTag;
import com.example.applemart.domain.PostsPhoto;
import com.example.applemart.domain.Tag;
import com.example.applemart.repository.PostRepository;
import com.example.applemart.service.PostService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @GetMapping("/posts") //등록된 전체 중고거래 글 조회 API
    public Result getPost(String searchKeyword) {
        if (searchKeyword == null) return new Result(postService.findPosts());
        else {
            return new Result(postService.findPostsBySearchKeyword(searchKeyword));
        }
    }

    @DeleteMapping("posts/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "Suc";
    }

    @PostMapping("/posts")//중고거래 글 등록 API
    public String savePost(//@RequestPart PostService.RequestPostForm form,
                           @RequestPart(name = "file", required = false) List<MultipartFile> files) {
        // 1. 게시물 등록
//        Long postId = postService.postSave(1l, form);

        // 2. 이미지 등록
        postService.savePostImages(1l, files);

        // 3. 태그 등록
//        postService.savePostTag(postId,);

        // ....
//        return CreatePostResponse(1L);
        return "Suc";
    }

    @PostMapping("/postex")
    public String saveP(@RequestBody PostService.RequestPostForm form) {
        postService.postSave(1L, form);
        return "good";
    }


    //상품DTO안에 포토DTO 만들기
    @Getter
    static class CreatePostDto {
        private List<PhotoPathDto> photoPath;
        private String title;
        private Long tag;
        private int price;
        private String content;

    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    static class CreatePostForm {
        private List<PostsPhoto> postsPhotos;
        private String title;
        private List<Tag> tags;
        private int price;
        private String content;
    }

    static class CreatePostResponse {
        private Long id;
    }

    @Data
    static class PhotoPathDto {
    }

}
