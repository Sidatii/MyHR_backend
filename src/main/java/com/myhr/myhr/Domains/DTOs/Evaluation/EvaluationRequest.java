package com.myhr.myhr.Domains.DTOs.Evaluation;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Evaluation}
 */
@Value
public class EvaluationRequest implements Serializable {
    String name;
    String description;
}