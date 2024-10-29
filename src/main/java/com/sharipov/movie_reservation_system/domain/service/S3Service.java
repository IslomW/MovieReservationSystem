package com.sharipov.movie_reservation_system.domain.service;


import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String uploadImage(MultipartFile file);
}
