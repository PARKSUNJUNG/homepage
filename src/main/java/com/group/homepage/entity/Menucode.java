package com.group.homepage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Menucode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    private String menuName;

    private Long menuParent;

    private int menuOrder;

    private String menuActive;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    // 소메뉴 리스트
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuParent", referencedColumnName = "menuId")
    @OrderBy("menuOrder ASC")
    private List<Menucode> subMenu;
}
