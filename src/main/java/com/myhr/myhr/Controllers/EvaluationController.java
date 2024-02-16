package com.myhr.myhr.Controllers;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Evaluation.EvaluationRequest;
import com.myhr.myhr.Domains.DTOs.Evaluation.EvaluationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/evaluation")
public class EvaluationController implements ServiceSpecification<EvaluationResponse, EvaluationRequest, Long> {

    /**
     * @param id 
     * @return
     */
    @GetMapping("/{id}")
    @Override
    public EvaluationResponse get(@PathVariable Long id) {
        return null;
    }

    /**
     * @param pageable 
     * @return
     */

    @GetMapping("/")
    @Override
    public Page<EvaluationResponse> getAll(Pageable pageable) {
        return null;
    }

    /**
     * @param evaluationRequest 
     * @return
     * @throws IOException
     */
    @PostMapping("/")
    @Override
    public EvaluationResponse create(EvaluationRequest evaluationRequest) throws IOException {
        return null;
    }

    /**
     * @param evaluationRequest 
     * @param id
     * @return
     * @throws IOException
     */

    @PutMapping("/{id}")
    @Override
    public EvaluationResponse update(EvaluationRequest evaluationRequest, @PathVariable Long id) throws IOException {
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
