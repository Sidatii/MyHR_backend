package com.myhr.myhr.Services;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Offer.OfferRequest;
import com.myhr.myhr.Domains.DTOs.Offer.OfferResponse;
import com.myhr.myhr.Domains.Entities.Offer;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Enums.OfferStatus;
import com.myhr.myhr.Repositories.OfferRepository;
import com.myhr.myhr.Repositories.RecruiterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OfferService implements ServiceSpecification<OfferResponse, OfferRequest, Long> {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final RecruiterRepository recruiterRepository;

    public OfferService(OfferRepository offerRepository, ModelMapper modelMapper, RecruiterRepository recruiterRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public OfferResponse get(Long id) {
        return modelMapper.map(offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found with id " + id)), OfferResponse.class);
    }

    @Override
    public Page<OfferResponse> getAll(Pageable pageable) {
        return offerRepository.findAll(pageable).map(offer -> modelMapper.map(offer, OfferResponse.class));
    }

    @Override
    public OfferResponse create(OfferRequest offerRequest) {
        Offer offer = modelMapper.map(offerRequest, Offer.class);
        Recruiter recruiter = recruiterRepository.findById(offerRequest.getRecruiter()).orElseThrow(() -> new RuntimeException("Recruiter not found with id " + offerRequest.getRecruiter()));
        offer.setRecruiter(recruiter);
        return modelMapper.map(offerRepository.save(offer), OfferResponse.class);
    }

    @Override
    public OfferResponse update(OfferRequest offerRequest, Long id) {
        Offer offer = modelMapper.map(offerRepository.findById(id), Offer.class);
        offer.setTitle(offerRequest.getTitle());
        offer.setDescription(offerRequest.getDescription());
        offer.setSalary(offerRequest.getSalary());
        offer.setCity(offerRequest.getCity());
        offer.setLevel(offerRequest.getLevel());
        offer.setProfile(offerRequest.getProfile());
        offer.setRecruiter(recruiterRepository.findById(offerRequest.getRecruiter()).orElseThrow(() -> new RuntimeException("Recruiter not found with id " + offerRequest.getRecruiter())));
        return modelMapper.map(offerRepository.save(offer), OfferResponse.class);
    }

    @Override
    public void delete(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found with the id" + id));
        offerRepository.delete(offer);
    }

    public void updateStatus(Long id, String status) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found with the id" + id));
        offer.setStatus(OfferStatus.valueOf(status));
        offerRepository.save(offer);
    }
}
