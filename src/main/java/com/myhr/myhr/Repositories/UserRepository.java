package com.myhr.myhr.Repositories;

import com.myhr.myhr.Domains.DTOs.User.UserResponse;
import com.myhr.myhr.Domains.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
