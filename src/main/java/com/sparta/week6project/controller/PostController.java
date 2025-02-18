package com.sparta.week6project.controller;

import com.sparta.week6project.dto.requestDto.PostRequestDto;
import com.sparta.week6project.dto.responseDto.PostResponseDto;
import com.sparta.week6project.service.PostService;
import com.sparta.week6project.service.S3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;
    private final S3Service s3Service;

    public PostController(PostService postService, S3Service s3Service){
        this.postService = postService;
        this.s3Service = s3Service;
    }
    public Long userId = 1L;

    // 게시글 작성
    @PostMapping("/posts/post")
    public void createBoard(@RequestBody PostRequestDto requestDto) {
//        Long userId = userDetails.getUser().getId();
        postService.createPost(userId, requestDto);
    }


    // 게시글 전체 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(Long userId) {
        return postService.getPosts(userId);
    }


    // 게시글 조회
    @GetMapping("/posts/post/{postId}")
    public PostResponseDto getBoard(@PathVariable Long postId, Long userId) {
        PostResponseDto postResponseDto = postService.getPost(postId, userId);
        System.out.println(postResponseDto.getIsHeart());
        return postResponseDto;
    }


    // 게시글 수정
    @PutMapping("/posts/post/{postId}")
    public void updateBoard(@PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
//        Long userId = userDetails.getUser().getId();
        postService.updatePost(postId, userId, requestDto);
    }


    // 게시글 삭제
    @DeleteMapping("/posts/post/{postId}")
    public void deleteBoard(@PathVariable Long postId) {
//        Long userId = userDetails.getUser().getId();
        postService.deletePost(postId, userId);
    }


    // 파일 업로드 테스트
    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file){
        System.out.println(file);
        return s3Service.upload(file);
    }

}
