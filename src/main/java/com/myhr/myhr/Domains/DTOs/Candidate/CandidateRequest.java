package com.myhr.myhr.Domains.DTOs.Candidate;

import com.myhr.myhr.Enums.Level;
import com.myhr.myhr.Enums.Role;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Candidate}
 */

public record CandidateRequest(String email, String password, List<Role> role, boolean active, List<MultipartFile> files,
                               String firstName, String lastName, String address, String phone,
                               Level level) implements Serializable {
}