package com.myhr.myhr.Domains.DTOs.Candidate;

import com.myhr.myhr.Domains.DTOs.Image.ImageRequest;
import com.myhr.myhr.Enums.Level;
import com.myhr.myhr.Enums.Role;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Candidate}
 */

public record CandidateRequest(String email, String password, Role role, boolean active, List<MultipartFile> files,
                               String firstName, String lastName, String address, String phone,
                               Level level) implements Serializable {
}