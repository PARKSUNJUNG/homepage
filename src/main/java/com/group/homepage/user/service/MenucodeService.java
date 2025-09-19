package com.group.homepage.user.service;


import com.group.homepage.dto.MenucodeDTO;
import com.group.homepage.entity.Menucode;
import com.group.homepage.repository.MenucodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenucodeService {

    private final MenucodeRepository menucodeRepository;

    public MenucodeService(MenucodeRepository menucodeRepository) {
        this.menucodeRepository = menucodeRepository;
    }

    public List<MenucodeDTO> getMenus(){
        List<Menucode> parentMenu = menucodeRepository.findByMenuParentIsNullOrderByMenuOrder();

        return parentMenu
                .stream()
                .map(parent -> new MenucodeDTO(
                        parent.getMenuId()
                        , parent.getMenuName()
                        , parent.getMenuParent()
                        , parent.getSubMenu()
                                .stream()
                                .map(sub -> new MenucodeDTO(sub.getMenuId(), sub.getMenuName(), sub.getMenuParent(), List.of()))
                                .toList()
                        )
                )
                .toList();
    }
}
