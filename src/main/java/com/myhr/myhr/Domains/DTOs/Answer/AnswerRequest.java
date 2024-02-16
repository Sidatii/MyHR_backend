package com.myhr.myhr.Domains.DTOs.Answer;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Answer}
 */
@Value
public class AnswerRequest implements Serializable {
    String answer;
    boolean correct;
    Long questionId;
}