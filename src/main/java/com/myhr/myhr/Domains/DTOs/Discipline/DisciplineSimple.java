package com.myhr.myhr.Domains.DTOs.Discipline;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Discipline}
 */
@Value
public class DisciplineSimple implements Serializable {
    Long id;
    String name;
    String description;
    String icon;
}