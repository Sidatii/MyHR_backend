package com.myhr.myhr.Domains.DTOs.File;

import com.myhr.myhr.Domains.DTOs.Application.ApplicationSimple;
import com.myhr.myhr.Domains.DTOs.Offer.OfferSimple;
import lombok.Data;

@Data
public class FileResponse {
    private Long id;
    private String name;
    private String type;
    private String url;
    private ApplicationSimple application;
}
