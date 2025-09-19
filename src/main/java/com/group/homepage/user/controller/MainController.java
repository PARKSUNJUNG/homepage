package com.group.homepage.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    // 메인 페이지
    @GetMapping("/")
    @ResponseBody
    public String mainPage(){
        //return "userMain";
        return "Home page placeholder";
    }
}
