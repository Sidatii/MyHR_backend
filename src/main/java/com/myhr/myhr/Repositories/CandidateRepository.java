package com.myhr.myhr.Repositories;

import com.myhr.myhr.Domains.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{
    Optional<Candidate> findByEmail(String email);
}
