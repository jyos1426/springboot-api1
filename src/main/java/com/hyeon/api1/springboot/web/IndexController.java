package com.hyeon.api1.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        // mustache-starter 덕분에 문자열 반환 시 경로와 확장자 자동 지정하여 view resolver가 처리
        // ex) src/main/resources/templates/###.mustache
        return "index";
    }
}
