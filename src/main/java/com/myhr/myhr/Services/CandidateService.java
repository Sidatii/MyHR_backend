package com.myhr.myhr.Services;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateRequest;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateResponse;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.Entities.Candidate;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Repositories.CandidateRepository;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CandidateService implements ServiceSpecification<CandidateResponse, CandidateRequest, Long> {

    private final CandidateRepository candidateRepository;
    private final ImageService imageService;
    private final EmailServiceImpl emailService;
    private final ModelMapper modelMapper;

    public CandidateService(CandidateRepository candidateRepository, ImageService imageService, EmailServiceImpl emailService, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.imageService = imageService;
        this.emailService = emailService;
        this.modelMapper = modelMapper;
    }

    @Override
    public CandidateResponse get(Long id) {
        return null;
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
