package com.hyeon.api1.springboot.web.dto;

import com.hyeon.api1.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Entity 클래스를 Request.Response 클래스로 사용하면 안됨
    // Entity 클래스를 기준으로 테이블, 스키마가 변경되기 때문
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
