package com.myhr.myhr.Repositories;

import com.myhr.myhr.Domains.DTOs.File.FileRequest;
import com.myhr.myhr.Domains.DTOs.File.FileResponse;
import com.myhr.myhr.Domains.Entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
