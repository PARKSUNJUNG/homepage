package com.group.homepage.admin.service;

import com.group.homepage.dto.ShareholderDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminShareholderServiceTest {

    @Autowired
    private AdminShareholderService adminShareholderService;

    @Test
    public void test() {
        int latestYear = adminShareholderService.findLatestYear();
        Assertions.assertThat(latestYear).isEqualTo(2025);
    }

    @Test
    void findByYear() {
        List<ShareholderDTO> list = adminShareholderService.findByYear(2025);
        System.out.println(list);
    }
}