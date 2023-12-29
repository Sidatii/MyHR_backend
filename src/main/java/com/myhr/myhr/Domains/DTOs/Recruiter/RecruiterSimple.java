package com.myhr.myhr.Domains.DTOs.Recruiter;

import lombok.Data;

@Data
public class RecruiterSimple {
    private Long id;
    private String email;
    private String password;
    private String address;
    private String phone;
}
