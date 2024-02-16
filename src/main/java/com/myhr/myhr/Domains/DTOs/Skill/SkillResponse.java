package com.myhr.myhr.Domains.DTOs.Skill;

import com.myhr.myhr.Domains.DTOs.Discipline.DisciplineSimple;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Skill}
 */
@Value
public class SkillResponse implements Serializable {
    Long id;
    String name;
    String description;
    DisciplineSimple discipline;
}