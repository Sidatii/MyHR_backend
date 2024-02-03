package com.myhr.myhr.Domains.DTOs.Candidate;

import com.myhr.myhr.Domains.Entities.Role;
import com.myhr.myhr.Enums.Level;
import lombok.Value;

import java.util.List;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Candidate}
 */
@Value
public class CandidateSimple {
    Long id;
    String email;
    String password;
    List<Role> role;
    boolean active;
    String firstName;
    String lastName;
    String address;
    String phone;
    Level level;
}