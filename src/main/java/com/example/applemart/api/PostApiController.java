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

import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @GetMapping("/api/v1/posts")
    public List<Post> postsV1() {
        return postService.findPosts();
    }

    @GetMapping("/api/v2/posts") //등록된 전체 게시물 조회
    public Result getPost() {
        List<Post> posts = postService.findPosts();
        List<PostListDto> all = posts.stream()
                .map(p -> new PostListDto(p.getId(),p.getTitle()))
                .collect(Collectors.toList());
        return new Result(all);
    }
//    @PostMapping("/api/v1/posts")//게시물 등록 API
//    public CreatePostResponse savePost(@RequestBody @Validated CreatePostDto dto) {
//        Post post = new Post();
//        PostsPhoto postsPhoto = new PostsPhoto();
//        PostTag postTag = new PostTag();
//        postsPhoto.setPhotoPath(dto.getPhotoPath());
//        post.setTitle(dto.getTitle());
//        post.setPrice(dto.getPrice());
//        post.setContent(dto.getContent());
//    }
//상품DTO안에 포토DTO 만들기
//    @Getter
//    static class CreatePostDto {
//        private List<PhotoPathDto> photoPath;
//        private String title;
//        private Long tag;
//        private int price;
//        private String content;
//
//        static class CreatePostsPhotoDto {
//            private
//        }
//    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    static class CreatePostResponse {
        private Long id;
    }

    @Data
    static class PhotoPathDto {
    }


    @Data
    @AllArgsConstructor
    static class PostListDto {
        private Long id;
        private String title;
    }
}
