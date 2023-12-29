package com.myhr.myhr.Services;

import com.myhr.myhr.Config.Cloudinary;
import com.myhr.myhr.Domains.DTOs.File.FileRequest;
import com.myhr.myhr.Domains.DTOs.File.FileResponse;
import com.myhr.myhr.Domains.Entities.File;
import com.myhr.myhr.Repositories.FileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    private final FileRepository fileRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public FileService(FileRepository fileRepository, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.fileRepository = fileRepository;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    public FileResponse create(FileRequest file) {
        File file1 = modelMapper.map(file, File.class);
        return modelMapper.map(fileRepository.save(file1), FileResponse.class);
    }

    public String uploadFile(MultipartFile file) {
        return cloudinaryService.uploadFile(file);
    }
}
