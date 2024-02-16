package com.myhr.myhr.Domains.DTOs.Skill;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Skill}
 */
@Value
public class SkillRequest implements Serializable {
    String name;
    String description;
    Long disciplineId;
}