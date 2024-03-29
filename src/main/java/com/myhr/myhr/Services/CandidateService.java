package com.myhr.myhr.Services;

import com.myhr.myhr.Auth.AuthenticationResponse;
import com.myhr.myhr.Config.JwtService;
import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateRegister;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateRequest;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateResponse;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.Entities.Candidate;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Domains.Entities.User;
import com.myhr.myhr.Enums.Role;
import com.myhr.myhr.Repositories.CandidateRepository;
import com.myhr.myhr.Repositories.RoleRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CandidateService implements ServiceSpecification<CandidateResponse, CandidateRequest, Long> {

    private final CandidateRepository candidateRepository;
    private final ImageService imageService;
    private final EmailServiceImpl emailService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private RoleRepository roleRepository;


    @Override
    public CandidateResponse get(Long id) {
        return null;
    }

    public AuthenticationResponse register(CandidateRegister request) {
        Candidate candidate = modelMapper.map(request, Candidate.class);
        candidate.setPassword(passwordEncoder.encode(request.getPassword()));
        com.myhr.myhr.Domains.Entities.Role role = roleRepository.findByName(String.valueOf(Role.ROLE_CANDIDATE)).orElseThrow(() -> new RuntimeException("role not found"));
        candidate.setRoles(Set.of(role));
        candidateRepository.save(candidate);
        String JwtToken = jwtService.generateToken(modelMapper.map(candidate, User.class));
        return AuthenticationResponse.builder()
                .token(JwtToken)
                .build();
    }

    @Override
    public Page<CandidateResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public CandidateResponse create(CandidateRequest candidateRequest) {
        return null;
    }

    @Override
    public CandidateResponse update(CandidateRequest candidateRequest, Long id) throws IOException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public RecruiterResponse verify(int code, String email, HttpSession session) {
        Candidate candidate = candidateRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Recruiter not found with email " + email));
        if (code == (int) session.getAttribute(email) ) {
            candidate.setActive(true);
            candidateRepository.save(candidate);
            return modelMapper.map(candidate, RecruiterResponse.class);
        } else {
            throw new RuntimeException("Wrong or expired code");
        }
    }

    public void sendVerificationCode(Recruiter recruiter, HttpSession session) {
        if (recruiter.isActive()) {
            throw new RuntimeException("Account already verified");
        }
        emailService.send(recruiter.getEmail(), "Account activation", "Hello, you can use this code to activate your account: " + session.getAttribute("code"));
    }
}
