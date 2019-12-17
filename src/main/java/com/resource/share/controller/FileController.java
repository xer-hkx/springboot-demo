package com.resource.share.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@RestController
public class FileController {

    @Value("${file.path}")
    private String filePath;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extName;
        FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(filePath + fileName)));
        return fileName;
    }

}
