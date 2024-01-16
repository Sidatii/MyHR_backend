package com.myhr.myhr.Controllers;

import com.myhr.myhr.Auth.AuthenticationResponse;
import com.myhr.myhr.Config.EmailService;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateRegister;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateRequest;
import com.myhr.myhr.Domains.DTOs.Candidate.CandidateResponse;
import com.myhr.myhr.Domains.DTOs.Image.ImageRequest;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterRegister;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.Entities.Candidate;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Domains.Entities.User;
import com.myhr.myhr.Enums.Role;
import com.myhr.myhr.Services.CandidateService;
import com.myhr.myhr.Services.EmailServiceImpl;
import com.myhr.myhr.Services.ImageService;
import com.myhr.myhr.Services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/candidate")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final ImageService imageService;
    private final EmailServiceImpl emailService;
    private final UserService userService;
    private final HttpSession session;





    @PostMapping("/create")
    public CandidateResponse register(@RequestAttribute CandidateRequest candidateRequest, HttpSession session) {

        List<ImageRequest> images = new ArrayList<>();
        candidateRequest.files().forEach(file -> {
            ImageRequest imageRequest = new ImageRequest(file);
            imageRequest.setUrl(imageService.uploadFile(file));
            images.add(imageRequest);
        });
        CandidateResponse candidateResponse = candidateService.create(candidateRequest);
        images.forEach(imageRequest -> {
            imageRequest.setRecruiterId(candidateResponse.getId());
            imageService.create(imageRequest);
        });
        int code = userService.generateVerificationCode();
        this.session.setAttribute(candidateResponse.getEmail(), code);
        // Send verification code
        emailService.send(candidateResponse.getEmail(), "Account activation", "Hello, you can use this code to activate your account: " + code);

        return candidateResponse;
    }


}
