package com.myhr.myhr.Domains.DTOs.Image;

import lombok.Data;

@Data
public class ImageResponse {
    private Long id;
    private String name;
    private String type;
    private String url;
    private Long recruiterId;
}
