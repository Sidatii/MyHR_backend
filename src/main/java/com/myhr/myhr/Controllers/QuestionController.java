package com.myhr.myhr.Controllers;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Question.QuestionRequest;
import com.myhr.myhr.Domains.DTOs.Question.QuestionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController implements ServiceSpecification<QuestionResponse, QuestionRequest, Long> {
    /**
     * @param id 
     * @return
     */

    @GetMapping("/{id}")
    @Override
    public QuestionResponse get(Long id) {
        return null;
    }

    /**
     * @param pageable 
     * @return
     */

    @GetMapping("/")
    @Override
    public Page<QuestionResponse> getAll(Pageable pageable) {
        return null;
    }

    /**
     * @param questionRequest 
     * @return
     * @throws IOException
     */

    @PostMapping("/")
    @Override
    public QuestionResponse create(QuestionRequest questionRequest) throws IOException {
        return null;
    }

    /**
     * @param questionRequest 
     * @param id
     * @return
     * @throws IOException
     */

    @PostMapping("/{id}")
    @Override
    public QuestionResponse update(QuestionRequest questionRequest, @PathVariable Long id) throws IOException {
        return null;
    }

    /**
     * @param id 
     */

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {

    }
}
