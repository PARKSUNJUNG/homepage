package com.group.homepage.repository;

import com.group.homepage.entity.Menucode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenucodeRepository extends JpaRepository<Menucode, Long> {

    List<Menucode> findByMenuParentIsNullOrderByMenuOrder();
}
