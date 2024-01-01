package com.myhr.myhr.Domains.DTOs.Recruiter;

import com.myhr.myhr.Domains.DTOs.Image.ImageSimple;
import lombok.Data;

import java.util.List;

@Data
public class RecruiterSimple {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private List<ImageSimple> images;
}
