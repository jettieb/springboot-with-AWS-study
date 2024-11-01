package com.book.springboot_with_AWS.web;

import com.book.springboot_with_AWS.service.posts.PostsService;
import com.book.springboot_with_AWS.web.dto.PostsResponseDto;
import com.book.springboot_with_AWS.web.dto.PostsSaveRequestDto;
import com.book.springboot_with_AWS.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;    //@autowired 사용하지 않고 생성자로 받는 방법

    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
        //서비스에서 저장하게 service로 넘기기
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    //전체 조회
    @GetMapping("/api/v1/posts")
    public List<PostsResponseDto> findAllDesc(){
        return postsService.findAllDesc();
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
}