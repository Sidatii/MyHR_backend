package com.myhr.myhr.Controllers;

import com.myhr.myhr.Domains.DTOs.Offer.OfferRequest;
import com.myhr.myhr.Domains.DTOs.Offer.OfferResponse;
import com.myhr.myhr.Repositories.OfferRepository;
import com.myhr.myhr.Services.OfferService;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/offer")
@CrossOrigin(origins = "http://localhost:4200")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    public OfferResponse get(@PathVariable Long id) {
        return offerService.get(id);
    }

    @GetMapping("/")
    public Page<OfferResponse> getAll(Pageable pageable) {
        return offerService.getAll(pageable);
    }

    @PostMapping("/create")
    public OfferResponse create(OfferRequest offerRequest) {
        return offerService.create(offerRequest);
    }

    @PatchMapping("/{id}")
    public OfferResponse update(OfferRequest offerRequest, @PathVariable Long id) {
        return offerService.update(offerRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        offerService.delete(id);
    }

    @PatchMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        offerService.updateStatus(id, status);
    }
}
