package com.myhr.myhr.Domains.DTOs.Question;

import com.myhr.myhr.Domains.DTOs.Answer.AnswerRequest;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Question}
 */
@Value
public class QuestionRequest implements Serializable {
    String question;
    Long evaluationId;
    Set<AnswerRequest> answers;
}