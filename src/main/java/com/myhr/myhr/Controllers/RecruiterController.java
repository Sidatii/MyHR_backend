package com.myhr.myhr.Controllers;

import com.myhr.myhr.Domains.DTOs.Image.ImageRequest;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterRequest;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Services.EmailServiceImpl;
import com.myhr.myhr.Services.ImageService;
import com.myhr.myhr.Services.RecruiterService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {

    private final RecruiterService recruiterService;
    private final ModelMapper modelMapper;
    private final ImageService imageService;
    private final EmailServiceImpl emailService;
    private final HttpSession session;

    public RecruiterController(RecruiterService recruiterService, ImageService imageService, ModelMapper modelMapper, EmailServiceImpl emailService, HttpSession session) {
        this.recruiterService = recruiterService;
        this.imageService = imageService;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
        this.session = session;
    }

    @GetMapping("/{id}")
    public RecruiterResponse get(@PathVariable Long id) {
        return recruiterService.get(id);
    }

    @GetMapping("/")
    public Page<RecruiterResponse> getAll(Pageable pageable, HttpSession session) {
        session.setAttribute("sessionId", session.getId());
        session.setAttribute("email", "cdscsdcsd@cqscs.com");
        return recruiterService.getAll(pageable);
    }

    @PostMapping("/create")
    public RecruiterResponse create(@ModelAttribute RecruiterRequest request, HttpSession session) {
        List<ImageRequest> images = new ArrayList<>();
        request.getFiles().forEach(file -> {
            ImageRequest imageRequest = new ImageRequest(file);
            imageRequest.setUrl(imageService.uploadFile(file));
            images.add(imageRequest);
        });
        RecruiterResponse recruiterResponse = recruiterService.create(request);
        images.forEach(imageRequest -> {
            imageRequest.setRecruiterId(recruiterResponse.getId());
            imageService.create(imageRequest);
        });
        int code = recruiterService.generateVerificationCode();
        this.session.setAttribute(recruiterResponse.getEmail(), code);
        // Send verification code
        emailService.send(recruiterResponse.getEmail(), "Account activation", "Hello, you can use this code to activate your account: " + code);

        return recruiterResponse;
    }

    @PatchMapping("/{id}")
    public RecruiterResponse update(@RequestBody RecruiterRequest request, @PathVariable Long id) {
        RecruiterResponse recruiterResponse = null;
        try {
            recruiterResponse = recruiterService.update(request, id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return recruiterResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recruiterService.delete(id);
    }

    @GetMapping("/verify")
    public RecruiterResponse verify(@RequestParam int code, @RequestParam String email, HttpSession session) {
        return recruiterService.verify(code, email, this.session);
    }

    @GetMapping("/session")
    public Object getSession() {
        Object emails = session.getAttribute("code");
        return emails;
    }

}
