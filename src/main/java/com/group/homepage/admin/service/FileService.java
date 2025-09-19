package com.group.homepage.admin.service;

import com.group.homepage.config.FileStorageProperties;
import com.group.homepage.entity.FileEntity;
import com.group.homepage.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final FileStorageProperties fileStorageProperties;

    @Transactional
    public FileEntity saveFile(MultipartFile multipartFile, String content, String category) throws IOException {
        String uploadDir = fileStorageProperties.getUpload() + File.separator + content + File.separator + category;
        String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String saveFileName = UUID.randomUUID().toString() + extension;

        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        Path savePath = uploadPath.resolve(saveFileName);
        Files.copy(multipartFile.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);

        FileEntity fileEntity = new FileEntity();
        fileEntity.setOriginName(multipartFile.getOriginalFilename());
        fileEntity.setSaveName(saveFileName);
        fileEntity.setFilePath("/" + content + "/" + category + "/" + saveFileName);
        fileEntity.setFileType(multipartFile.getContentType());

        return fileRepository.save(fileEntity);
    }
}
