package com.myhr.myhr.Domains.DTOs.Skill;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Skill}
 */
@Value
public class SkillSimple implements Serializable {
    Long id;
    String name;
    String description;
}