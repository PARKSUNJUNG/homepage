package com.group.homepage.dto;

import com.group.homepage.entity.FileEntity;

public class FileDTO {

    private Long fileId;

    private String originName;

    private String saveName;

    private String filePath;

    private String fileType;

    public FileDTO(Long fileId, String originName, String saveName, String filePath, String fileType) {
        this.fileId = fileId;
        this.originName = originName;
        this.saveName = saveName;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public FileEntity toEntity() {
        FileEntity entity = new FileEntity();
        entity.setFileId(this.fileId);
        entity.setOriginName(this.originName);
        entity.setSaveName(this.originName);
        entity.setSaveName(this.saveName);
        entity.setFilePath(this.filePath);
        entity.setFileType(this.fileType);
        return entity;
    }
}
