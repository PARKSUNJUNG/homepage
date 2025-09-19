package com.group.homepage.admin.controller;

import com.group.homepage.config.FileStorageProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileStorageProperties fileStorageProperties;

    @GetMapping("/api/upload/**")
    public ResponseEntity<Resource> getUploadFile(HttpServletRequest request){
        String basePath = fileStorageProperties.getUpload();
        String path = request.getRequestURI().substring("/api/upload".length());

        File file = new File(basePath + path);

        if(!file.exists() || !file.isFile()){
            return ResponseEntity.notFound().build();
        }

        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok().body(resource);
    }
}
