package com.myhr.myhr.Domains.DTOs.Application;

import com.myhr.myhr.Domains.DTOs.File.FileSimple;
import com.myhr.myhr.Enums.Assessment;
import lombok.Data;

import java.util.List;

@Data
public class ApplicationSimple {
    private Long id;
    private String fullName;
    private String email;
    private Assessment assessment;
    private List<FileSimple> files;
}
