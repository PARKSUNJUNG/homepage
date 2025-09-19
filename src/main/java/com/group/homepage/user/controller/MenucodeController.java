package com.group.homepage.user.controller;


import com.group.homepage.dto.MenucodeDTO;
import com.group.homepage.user.service.MenucodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenucodeController {

    private final MenucodeService menucodeService;

    public MenucodeController(MenucodeService menucodeService) {
        this.menucodeService = menucodeService;
    }

    @GetMapping("/menucode")
    public List<MenucodeDTO> getMenuName(){
        return menucodeService.getMenus();
    }
}
