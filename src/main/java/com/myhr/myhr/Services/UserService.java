package com.myhr.myhr.Services;

import com.myhr.myhr.Auth.AuthenticationResponse;
import com.myhr.myhr.Config.JwtService;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.DTOs.User.AuthRequest;
import com.myhr.myhr.Domains.DTOs.User.UserResponse;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Domains.Entities.User;
import com.myhr.myhr.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("This username was not found"));
        String JwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(JwtToken)
                .build();
    }

    public int generateVerificationCode() {
        return (int) (Math.random() * 1000000);
    }
}
