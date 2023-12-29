package com.myhr.myhr.Domains.DTOs.Image;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageRequest {
    private String name;
    private String type;
    private String url;
    private MultipartFile file;
    private Long recruiterId;

    public ImageRequest(MultipartFile file) {
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
