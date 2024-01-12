package com.myhr.myhr.Domains.DTOs.Candidate;

import com.myhr.myhr.Domains.DTOs.Application.ApplicationSimple;
import com.myhr.myhr.Domains.DTOs.Image.ImageSimple;
import com.myhr.myhr.Domains.DTOs.Offer.OfferSimple;
import com.myhr.myhr.Enums.Level;
import com.myhr.myhr.Enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class CandidateResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean active;
    private Role role;
    private Level level;
    private List<ImageSimple> images;
    private List<ApplicationSimple> applications;

}
