package com.group.homepage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "bodmem")
public class Bod {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bodmemId;

    private Long menuId;

    private String bodType;

    private String name;

    private LocalDate date;

    private String careerHistory1;

    private String careerHistory2;

    private String careerHistory3;

    private char useYn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private FileEntity file;

}
