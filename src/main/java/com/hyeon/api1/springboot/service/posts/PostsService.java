package com.hyeon.api1.springboot.service.posts;
import com.hyeon.api1.springboot.domain.posts.Posts;
import com.hyeon.api1.springboot.domain.posts.PostsRepository;
import com.hyeon.api1.springboot.web.dto.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // TODO, 생성자로 Bean 객체 주입하는 것과 비교
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requetDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다, id=" + id)
                );
        posts.update(requetDto.getTitle(), requetDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다, id=" + id)
                );

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                // .map(posts -> new PostsListResponseDto(posts)) 와 동일
                .collect(Collectors.toList());
    }
}