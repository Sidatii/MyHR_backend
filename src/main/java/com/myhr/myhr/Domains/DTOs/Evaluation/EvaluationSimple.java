package com.myhr.myhr.Domains.DTOs.Evaluation;

import com.myhr.myhr.Domains.DTOs.Question.QuestionSimple;
import com.myhr.myhr.Domains.DTOs.Skill.SkillSimple;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Evaluation}
 */
@Value
public class EvaluationSimple implements Serializable {
    Long id;
    String name;
    String description;
    SkillSimple skill;
    Set<QuestionSimple> questions;
}