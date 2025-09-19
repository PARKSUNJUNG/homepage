package com.group.homepage.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.homepage.entity.Menucode;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MenucodeRepositoryTest {

    @Autowired
    private MenucodeRepository menucodeRepository;

    @Test
    void 실제로_값을_잘가져오는가(){
        // when
        List<Menucode> result = menucodeRepository.findByMenuParentIsNullOrderByMenuOrder();

        // then
        assertThat(result).isNotEmpty();
        result.forEach(menu -> {
            System.out.println(menu.getMenuName() + " / MenuOrder: " + menu.getMenuOrder() + " / MenuParent: " + menu.getMenuParent());
        });
    }
}