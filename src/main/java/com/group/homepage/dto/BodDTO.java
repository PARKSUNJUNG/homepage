package com.group.homepage.dto;

import com.group.homepage.entity.Bod;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BodDTO {

    private Long bodmemId;

    private Long menuId;

    private String bodType;

    private String name;

    private LocalDate date;

    private String careerHistory1;

    private String careerHistory2;

    private String careerHistory3;

    private String filePath;

    private char useYn;

    public BodDTO(Long bodmemId, Long menuId, String bodType, String name, LocalDate date, String careerHistory1, String careerHistory2, String careerHistory3, String filePath, char useYn) {
        this.bodmemId = bodmemId;
        this.menuId = menuId;
        this.bodType = bodType;
        this.name = name;
        this.date = date;
        this.careerHistory1 = careerHistory1;
        this.careerHistory2 = careerHistory2;
        this.careerHistory3 = careerHistory3;
        this.filePath = filePath;
        this.useYn = useYn;
    }

    public Bod toEntity() {
        Bod entity = new Bod();
        entity.setBodmemId(this.bodmemId);
        entity.setMenuId(this.menuId);
        entity.setBodType(this.bodType);
        entity.setName(this.name);
        entity.setDate(this.date);
        entity.setCareerHistory1(this.careerHistory1);
        entity.setCareerHistory2(this.careerHistory2);
        entity.setCareerHistory3(this.careerHistory3);
        entity.setUseYn(this.useYn);
        return entity;
    }

    public static BodDTO fromEntity(Bod entity) {
        return new BodDTO(
                entity.getBodmemId(),
                entity.getMenuId(),
                entity.getBodType(),
                entity.getName(),
                entity.getDate(),
                entity.getCareerHistory1(),
                entity.getCareerHistory2(),
                entity.getCareerHistory3(),
                entity.getFile().getFilePath(),
                entity.getUseYn()
        );
    }
}
