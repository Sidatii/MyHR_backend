package com.myhr.myhr.Domains.DTOs.Question;

import com.myhr.myhr.Domains.DTOs.Answer.AnswerSimple;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.myhr.myhr.Domains.Entities.Question}
 */
@Value
public class QuestionSimple implements Serializable {
    Long id;
    String question;
    Set<AnswerSimple> answers;
}