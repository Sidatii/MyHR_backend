package com.myhr.myhr.Domains.DTOs.File;

import lombok.Data;

@Data
public class FileSimple {
    private Long id;
    private String name;
    private String type;
    private String url;
}
