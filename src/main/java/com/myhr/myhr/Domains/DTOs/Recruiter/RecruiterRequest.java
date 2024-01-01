package com.myhr.myhr.Domains.DTOs.Recruiter;

import com.myhr.myhr.Domains.DTOs.Image.ImageRequest;
import com.myhr.myhr.Domains.DTOs.Image.ImageSimple;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RecruiterRequest {
    private String name;
    private String email;
    private String password;
    private String address;
    private String phone;
    private List<MultipartFile> files;
    private List<ImageSimple> images;
}
