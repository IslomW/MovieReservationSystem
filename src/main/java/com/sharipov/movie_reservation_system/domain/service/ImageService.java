package com.sharipov.movie_reservation_system.domain.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImage(MultipartFile file) throws IOException;
}
