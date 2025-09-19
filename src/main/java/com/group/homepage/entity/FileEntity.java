package com.group.homepage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "file")
public class FileEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    private String originName;

    private String saveName;

    private String filePath;

    private String fileType;

}
