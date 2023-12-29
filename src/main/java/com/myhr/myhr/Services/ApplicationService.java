package com.myhr.myhr.Services;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Application.ApplicationRequest;
import com.myhr.myhr.Domains.DTOs.Application.ApplicationResponse;
import com.myhr.myhr.Domains.Entities.Application;
import com.myhr.myhr.Domains.Entities.Offer;
import com.myhr.myhr.Enums.Assessment;
import com.myhr.myhr.Repositories.ApplicationRepository;
import com.myhr.myhr.Repositories.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements ServiceSpecification<ApplicationResponse, ApplicationRequest, Long> {
    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;


    public ApplicationService(ApplicationRepository applicationRepository, ModelMapper modelMapper, OfferRepository offerRepository) {
        this.applicationRepository = applicationRepository;
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
    }

    @Override
    public ApplicationResponse get(Long id) {
        return applicationRepository.findById(id).map(application -> modelMapper.map(application, ApplicationResponse.class))
                .orElseThrow(() -> new RuntimeException("Competition not found with id " + id));

    }

    @Override
    public Page<ApplicationResponse> getAll(Pageable pageable) {
        return applicationRepository.findAll(pageable).map(application -> modelMapper.map(application, ApplicationResponse.class));
    }

    @Override
    public ApplicationResponse create(ApplicationRequest applicationRequest) {
        Application application = modelMapper.map(applicationRequest, Application.class);
        application.setId(30L);
//        application.setId(null);
        Offer offer = offerRepository.findById(applicationRequest.getOffer()).orElseThrow(() -> new RuntimeException("Offer not found with id " + applicationRequest.getOffer()));
        application.setOffer(offer);
        Application application1 = applicationRepository.save(application);
        return modelMapper.map(application1, ApplicationResponse.class);
    }

    @Override
    public ApplicationResponse update(ApplicationRequest applicationRequest, Long Id) {
        Application application = applicationRepository.findById(Id).orElseThrow(() -> new RuntimeException("Application not found with id " + Id));
        application.setFullName(applicationRequest.getFullName());
        application.setEmail(applicationRequest.getEmail());
        application.setOffer(offerRepository.findById(applicationRequest.getOffer()).orElseThrow(() -> new RuntimeException("Offer not found with id " + applicationRequest.getOffer())));
        return modelMapper.map(applicationRepository.save(application), ApplicationResponse.class);
    }

    @Override
    public void delete(Long id) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found with id" + id));
        applicationRepository.delete(application);
    }

    public void updateAssessment(Long id, String status) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found with id" + id));
        application.setAssessment(Assessment.valueOf(status));
        applicationRepository.save(application);
    }
}
