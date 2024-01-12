package com.myhr.myhr.Domains.DTOs.Candidate;

import com.myhr.myhr.Enums.Level;
import com.myhr.myhr.Enums.Role;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Candidate}
 */
@Value
public class CandidateSimple {
    Long id;
    String email;
    String password;
    Role role;
    boolean active;
    String firstName;
    String lastName;
    String address;
    String phone;
    Level level;
}