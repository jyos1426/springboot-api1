package com.hyeon.api1.springboot.web;

import com.hyeon.api1.springboot.service.posts.PostsService;
import com.hyeon.api1.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());

        // mustache-starter 덕분에 문자열 반환 시 경로와 확장자 자동 지정하여 view resolver가 처리
        // ex) src/main/resources/templates/###.mustache
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
