package com.myhr.myhr.Domains.DTOs.Application;

import com.myhr.myhr.Domains.DTOs.File.FileSimple;
import com.myhr.myhr.Domains.DTOs.Offer.OfferSimple;
import com.myhr.myhr.Domains.Entities.File;
import com.myhr.myhr.Domains.Entities.Offer;
import com.myhr.myhr.Enums.Assessment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ApplicationResponse {
    private Long id;
    private String fullName;
    private String email;
    private List<FileSimple> files;
    private Assessment assessment;
    private OfferSimple offer;
}
