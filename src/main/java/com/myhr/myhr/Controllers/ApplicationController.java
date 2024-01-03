package com.myhr.myhr.Controllers;

import com.myhr.myhr.Domains.DTOs.Application.ApplicationRequest;
import com.myhr.myhr.Domains.DTOs.Application.ApplicationResponse;
import com.myhr.myhr.Domains.DTOs.File.FileRequest;
import com.myhr.myhr.Services.ApplicationService;
import com.myhr.myhr.Services.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/application")
@CrossOrigin(origins = "*")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final ModelMapper modelMapper;
    private final FileService fileService;

    public ApplicationController(ApplicationService applicationService, ModelMapper modelMapper, FileService fileService) {
        this.applicationService = applicationService;
        this.modelMapper = modelMapper;
        this.fileService = fileService;
    }

    @GetMapping("/{id}")
    public ApplicationResponse getById(@PathVariable Long id) {
        return applicationService.get(id);
    }
    @GetMapping("/")
    public Page<ApplicationResponse> getAll(Pageable pageable) {
        return applicationService.getAll(pageable);
    }

    @PostMapping("/create")
    public ApplicationResponse create(@ModelAttribute ApplicationRequest applicationRequest) {
        System.out.println(applicationRequest);
        List<FileRequest> files = new ArrayList<>();
        if (applicationRequest.getFileList() != null) {
            applicationRequest.getFileList().forEach(file -> {
                FileRequest fileRequest = new FileRequest(file);
                fileRequest.setUrl(fileService.uploadFile(file));
                files.add(fileRequest);
            });
        }
        ApplicationResponse applicationResponse = applicationService.create(applicationRequest);
        System.out.println(applicationResponse);
        files.forEach(file -> {
            file.setApplicationId(applicationResponse.getId());
            System.out.println(file);
            fileService.create(file);
        });
        return applicationResponse;
    }

    @PatchMapping("/{id}")
    public void updateAssessment(@PathVariable Long id, @RequestParam String status) {
        applicationService.updateAssessment(id, status);
    }
}
