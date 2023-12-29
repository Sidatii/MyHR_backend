package com.myhr.myhr.Domains.DTOs.Offer;

import com.myhr.myhr.Enums.Level;
import com.myhr.myhr.Enums.Profile;
import lombok.Data;

@Data
public class OfferRequest {
    private String title;
    private String description;
    private String city;
    private Profile profile;
    private Level level;
    private double salary;
    private Long recruiter;
}
