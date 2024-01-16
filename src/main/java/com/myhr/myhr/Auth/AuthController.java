package com.myhr.myhr.Auth;

import com.myhr.myhr.Domains.DTOs.Candidate.CandidateRegister;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterRegister;
import com.myhr.myhr.Domains.DTOs.User.AuthRequest;
import com.myhr.myhr.Services.CandidateService;
import com.myhr.myhr.Services.RecruiterService;
import com.myhr.myhr.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CandidateService candidateService;
    private final RecruiterService recruiterService;
    private final UserService userService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthRequest authRequest){
        return userService.login(authRequest);
    }

    @PostMapping("/candidate/register")
    public AuthenticationResponse register(@RequestBody CandidateRegister candidateRegister){
        return candidateService.register(candidateRegister);
    }

    @PostMapping("/recruiter/register")
    public AuthenticationResponse register(@RequestBody RecruiterRegister recruiterRegister){
        return recruiterService.register(recruiterRegister);
    }

}
