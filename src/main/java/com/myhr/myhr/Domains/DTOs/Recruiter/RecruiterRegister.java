package com.myhr.myhr.Domains.DTOs.Recruiter;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Recruiter}
 */
@Value
public class RecruiterRegister implements Serializable {
    @NotNull
    String email;
    @NotNull
    String password;
    String name;
    String address;
    String phone;
}