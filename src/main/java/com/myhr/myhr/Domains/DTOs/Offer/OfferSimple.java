package com.myhr.myhr.Domains.DTOs.Offer;

import com.myhr.myhr.Enums.OfferStatus;
import lombok.Data;

@Data
public class OfferSimple {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String city;
    private String profile;
    private String level;
    private double salary;
    private OfferStatus status;
}
