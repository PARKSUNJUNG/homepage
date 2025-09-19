package com.group.homepage.user.service;

import com.group.homepage.dto.MenucodeDTO;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MenucodeServiceTest {

    @Autowired
    private MenucodeService menucodeService;

    @Test
    void 기능_테스트(){
        // 실제 db 조회
        List<MenucodeDTO> result = menucodeService.getMenus();

        String list = menucodeService.toString();
        System.out.println("list: "+list);

        // 조회 결과 검증
        assertThat(result).isNotEmpty();
        result.forEach(dto -> System.out.println("id: "+dto.getMenuId()+"___"+dto.getMenuName()));


    }
}