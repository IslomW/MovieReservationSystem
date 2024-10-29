package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.config.props.S3ConfigProperties;
import com.sharipov.movie_reservation_system.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;



@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final S3Client s3Client;
    private final S3ConfigProperties configProperties;



    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(configProperties.getBucketName())
                .key(fileName)
                .build();


        PutObjectResponse response = s3Client.putObject(
                putObjectRequest,
                RequestBody.fromInputStream(file.getInputStream(), file.getSize())
        );


        return s3Client.utilities().getUrl(b -> b.bucket(configProperties.getBucketName()).key(fileName)).toString();
    }
}
