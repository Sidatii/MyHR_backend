package com.myhr.myhr.Domains.DTOs.User;

import com.myhr.myhr.Domains.DTOs.Image.ImageRequest;
import com.myhr.myhr.Domains.Entities.Role;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.User}
 */
@Value
public class UserResponse implements Serializable {
    Long id;
    String email;
    String password;
    List<Role> roles;
    boolean active;
    List<ImageRequest> images;
}