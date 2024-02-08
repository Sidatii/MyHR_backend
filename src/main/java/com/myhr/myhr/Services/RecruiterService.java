package com.myhr.myhr.Services;

import com.myhr.myhr.Auth.AuthenticationResponse;
import com.myhr.myhr.Config.JwtService;
import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterRegister;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterRequest;
import com.myhr.myhr.Domains.DTOs.Recruiter.RecruiterResponse;
import com.myhr.myhr.Domains.Entities.Recruiter;
import com.myhr.myhr.Domains.Entities.Role;
import com.myhr.myhr.Domains.Entities.User;
import com.myhr.myhr.Repositories.RecruiterRepository;
import com.myhr.myhr.Repositories.RoleRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecruiterService implements ServiceSpecification<RecruiterResponse, RecruiterRequest, Long>{
    private final RecruiterRepository recruiterRepository;
    private final ModelMapper modelMapper;
    private final EmailServiceImpl emailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;
//    private final Session session;


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

    public AuthenticationResponse register(RecruiterRegister request) {
        Recruiter recruiter = modelMapper.map(request, Recruiter.class);
        recruiter.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleRepository.findByName(String.valueOf(com.myhr.myhr.Enums.Role.ROLE_RECRUITER)).orElseThrow(() -> new RuntimeException("role not found"));
        recruiter.setRoles(Set.of(role));
        recruiterRepository.save(recruiter);
        String JwtToken = jwtService.generateToken(modelMapper.map(recruiter, User.class));
        return AuthenticationResponse.builder()
                .token(JwtToken)
                .build();
    }
}
