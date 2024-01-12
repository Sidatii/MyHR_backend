package com.myhr.myhr.Services;

import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.Entities.Recruiter;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public int generateVerificationCode() {
        return (int) (Math.random() * 1000000);
    }
}
