package com.myhr.myhr.Domains.DTOs.Candidate;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Candidate}
 */
@Value
public class CandidateRegister implements Serializable {
    @NotNull
    String email;
    @NotNull
    String password;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
}