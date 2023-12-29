package com.myhr.myhr.Domains.DTOs.File;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRequest {
    private String name;
    private String type;
    private String url;
    private Long applicationId;

    private MultipartFile file;

    public FileRequest(MultipartFile file) {
        this.file = file;
        setName(file);
        setType(file);
    }

    public void setName(MultipartFile file) {
        this.name = file.getOriginalFilename();
    }

    public void setType(MultipartFile file) {
        this.type = file.getContentType();
    }
}
