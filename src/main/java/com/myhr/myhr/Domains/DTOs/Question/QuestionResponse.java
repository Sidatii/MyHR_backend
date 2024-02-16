package com.myhr.myhr.Domains.DTOs.Question;

import com.myhr.myhr.Domains.DTOs.Answer.AnswerSimple;
import com.myhr.myhr.Domains.DTOs.Evaluation.EvaluationSimple;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Question}
 */
@Value
public class QuestionResponse implements Serializable {
    Long id;
    String question;
    EvaluationSimple evaluation;
    Set<AnswerSimple> answers;
}