package com.myhr.myhr.Repositories;

import com.myhr.myhr.Domains.Entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Optional<Recruiter> findByEmail(String email);
}
