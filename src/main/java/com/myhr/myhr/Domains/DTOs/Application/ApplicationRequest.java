package com.myhr.myhr.Domains.DTOs.Application;

import com.myhr.myhr.Domains.DTOs.File.FileRequest;
import com.myhr.myhr.Enums.Assessment;
import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ApplicationRequest {
    private String fullName;
    private String email;
    private Long offer;
    private List<MultipartFile> fileList;
}
