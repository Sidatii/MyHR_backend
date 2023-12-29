package com.myhr.myhr.Services;

import com.myhr.myhr.Config.ServiceSpecification;
import com.myhr.myhr.Domains.DTOs.Image.ImageRequest;
import com.myhr.myhr.Domains.DTOs.Image.ImageResponse;
import com.myhr.myhr.Domains.Entities.Images;
import com.myhr.myhr.Repositories.ImageRepository;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService implements ServiceSpecification<ImageResponse, ImageRequest, Long> {

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    public ImageService(ImageRepository imageRepository, ModelMapper modelMapper, CloudinaryService cloudinaryService) {
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public ImageResponse get(Long id) {
        return null;
    }

    @Override
    public Page<ImageResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ImageResponse create(ImageRequest imageRequest){
        Images image = modelMapper.map(imageRequest, Images.class);
        return modelMapper.map(imageRepository.save(image), ImageResponse.class);
    }

    @Override
    public ImageResponse update(ImageRequest imageRequest, Long id) throws IOException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public String uploadFile(MultipartFile file) {
        return cloudinaryService.uploadFile(file);
    }
}
