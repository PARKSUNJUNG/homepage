package com.group.homepage.repository;

import com.group.homepage.dto.ShareholderDTO;
import com.group.homepage.entity.Shareholder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShareholderRepositoryTest {

    @Autowired
    private ShareholderRepository shareholderRepository;

    @Test
    public void testLatestYear() {
        Integer latestYear = shareholderRepository.findLatestYear();
        System.out.println("latestYear: "+latestYear);
    }

    @Test
    public void testfindlist() {
        int year = 2025;
        List<Shareholder> list = shareholderRepository.findByYear(year);
        System.out.println("list.size() = " + list.size());
        System.out.println(list);
    }
}