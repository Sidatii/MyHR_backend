package com.myhr.myhr.Domains.DTOs.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.User}
 */
@Value
public class AuthRequest implements Serializable {
    @NotNull
    @NotEmpty
    String email;
    @NotNull
    @NotEmpty
    String password;
}