package com.myhr.myhr.Services;

//import com.myhr.myhr.Config.LocalSession;
import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterRequest;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Repositories.RecruiterRepository;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RecruiterService implements ServiceSpecification<RecruiterResponse, RecruiterRequest, Long>{
    private final RecruiterRepository recruiterRepository;
    private final ModelMapper modelMapper;
    private final EmailServiceImpl emailService;
//    private final Session session;

    public RecruiterService(RecruiterRepository recruiterRepository, ModelMapper modelMapper, EmailServiceImpl emailService) {
        this.recruiterRepository = recruiterRepository;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
    }

    @Override
    public RecruiterResponse get(Long id) {
        return modelMapper.map(recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found with id " + id)), RecruiterResponse.class);

    }

    @Override
    public Page<RecruiterResponse> getAll(Pageable pageable) {
        return recruiterRepository.findAll(pageable).map(recruiter -> modelMapper.map(recruiter, RecruiterResponse.class));
    }

    @Override
    public RecruiterResponse create(RecruiterRequest recruiterRequest) {
        if (recruiterRepository.findByEmail(recruiterRequest.getEmail().toLowerCase()).isPresent()) {
            throw new RuntimeException("Email already used");
        }
//        // If not, create the recruiter
        Recruiter recruiter = recruiterRepository.save(modelMapper.map(recruiterRequest, Recruiter.class));
        return modelMapper.map(recruiter, RecruiterResponse.class);
    }

    @Override
    public RecruiterResponse update(RecruiterRequest recruiterRequest, Long Id) throws IOException {
        Recruiter recruiter = modelMapper.map(recruiterRepository.findById(Id), Recruiter.class);
        recruiter.setAddress(recruiterRequest.getAddress());
        recruiter.setEmail(recruiterRequest.getEmail());
        recruiter.setPassword(recruiterRequest.getPassword());
        recruiter.setPhone(recruiterRequest.getPhone());
        return modelMapper.map(recruiterRepository.save(recruiter), RecruiterResponse.class);

    }

    @Override
    public void delete(Long id) {
        Recruiter recruiter = recruiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Recruiter not found with the id" + id));
        recruiterRepository.delete(recruiter);

    }

    public RecruiterResponse login(RecruiterRequest recruiterRequest) {
        return new RecruiterResponse();
    }

    public int generateVerificationCode() {
        return (int) (Math.random() * 1000000);
    }

    public RecruiterResponse verify(int code, String email, HttpSession session) {
        Recruiter recruiter = recruiterRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Recruiter not found with email " + email));
        if (code == (int) session.getAttribute(email) ) {
            recruiter.setActive(true);
            recruiterRepository.save(recruiter);
            return modelMapper.map(recruiter, RecruiterResponse.class);
        } else {
            throw new RuntimeException("Wrong or expired code");
        }
    }

    public void sendVerificationCode(Recruiter recruiter, HttpSession session) {
        if (recruiter.isActive()) {
            throw new RuntimeException("Account already verified");
        }
        emailService.send(recruiter.getEmail(), "Account activation", "Hello, you can use this code to activate your account: " + session.getAttribute("code"));
    }
}
