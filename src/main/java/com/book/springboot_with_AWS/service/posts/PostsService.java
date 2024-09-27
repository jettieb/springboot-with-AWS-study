package com.book.springboot_with_AWS.service.posts;

import com.book.springboot_with_AWS.domain.posts.Posts;
import com.book.springboot_with_AWS.domain.posts.PostsRepository;
import com.book.springboot_with_AWS.web.dto.PostsSaveRequestDto;
import com.book.springboot_with_AWS.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    //등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
        //repository에서 저장하고 나서 저장한 엔티티의 id 반환
    }

    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}
