package com.myhr.myhr.Controllers;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Discipline.DisciplineRequest;
import com.myhr.myhr.Domains.DTOs.Discipline.DisciplineResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/discipline")
public class DisciplineController implements ServiceSpecification<DisciplineResponse, DisciplineRequest, Long> {
    /**
     * @param id 
     * @return
     */

    @GetMapping("/{id}")
    @Override
    public DisciplineResponse get(@PathVariable Long id) {
        return null;
    }

    /**
     * @param pageable 
     * @return
     */

    @GetMapping("/")
    @Override
    public Page<DisciplineResponse> getAll(Pageable pageable) {
        return null;
    }

    /**
     * @param disciplineRequest 
     * @return
     * @throws IOException
     */

    @PostMapping("/")
    @Override
    public DisciplineResponse create(DisciplineRequest disciplineRequest) throws IOException {
        return null;
    }

    /**
     * @param disciplineRequest 
     * @param id
     * @return
     * @throws IOException
     */

    @PutMapping("/{id}")
    @Override
    public DisciplineResponse update(DisciplineRequest disciplineRequest, @PathVariable Long id) throws IOException {
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
