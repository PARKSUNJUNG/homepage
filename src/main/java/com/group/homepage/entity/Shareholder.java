package com.group.homepage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Shareholder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shareId;

    private Long menuId;

    private LocalDate date;

    private int round;

    private String contents;

    private String decision;

    private char useYn;
}
