package com.group.homepage.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class LoginController {
    
    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage(){
        //return "adminLogin";
        return "Login page placeholder";
    }
}
