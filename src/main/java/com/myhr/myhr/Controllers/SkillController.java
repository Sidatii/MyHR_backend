package com.myhr.myhr.Controllers;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Skill.SkillRequest;
import com.myhr.myhr.Domains.DTOs.Skill.SkillResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/skill")
public class SkillController implements ServiceSpecification<SkillResponse, SkillRequest, Long> {
    /**
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    @Override
    public SkillResponse get(@PathVariable Long id) {
        return null;
    }

    /**
     * @param pageable
     * @return
     */

    @GetMapping("/")
    @Override
    public Page<SkillResponse> getAll(Pageable pageable) {
        return null;
    }

    /**
     * @param skillRequest
     * @return
     * @throws IOException
     */

    @PostMapping("/")
    @Override
    public SkillResponse create(SkillRequest skillRequest) throws IOException {
        return null;
    }

    /**
     * @param skillRequest
     * @param id
     * @return
     * @throws IOException
     */

    @PostMapping("/{id}")
    @Override
    public SkillResponse update(SkillRequest skillRequest, @PathVariable Long id) throws IOException {
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
