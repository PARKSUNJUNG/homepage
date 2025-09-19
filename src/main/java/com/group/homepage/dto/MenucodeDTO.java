package com.group.homepage.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MenucodeDTO {

    private Long menuId;
    private String menuName;
    private Long menuParent;
    private List<MenucodeDTO> subMenu; // 소메뉴 리스트

    public MenucodeDTO(Long menuId, String menuName, Long menuParent, List<MenucodeDTO> subMenu) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuParent = menuParent;
        this.subMenu = subMenu;
    }
}
