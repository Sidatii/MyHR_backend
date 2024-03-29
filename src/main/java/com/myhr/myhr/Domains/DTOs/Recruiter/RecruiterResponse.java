package com.myhr.myhr.Domains.DTOs.Recruiter;

import com.myhr.myhr.Domains.DTOs.Image.ImageSimple;
import com.myhr.myhr.Domains.DTOs.Offer.OfferSimple;
import com.myhr.myhr.Domains.Entities.Role;
import lombok.Data;

import java.util.List;

@Data
public class RecruiterResponse {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private List<Role> roles;
    private List<ImageSimple> images;
    private List<OfferSimple> offers;
}
