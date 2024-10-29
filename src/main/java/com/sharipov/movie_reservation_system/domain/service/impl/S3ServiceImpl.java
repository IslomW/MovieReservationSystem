package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.config.props.S3ConfigProperties;
import com.sharipov.movie_reservation_system.domain.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    private final S3Client s3Client;
    private final S3ConfigProperties configProperties;



    @Override
    public String uploadImage(MultipartFile file) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(configProperties.getBucketName())
                .key(fileName)
                .build();


        PutObjectResponse response = s3Client.putObject(
                putObjectRequest,
                Paths.get(file.getOriginalFilename())
        );


        return s3Client.utilities().getUrl(b -> b.bucket(configProperties.getBucketName()).key(fileName)).toString();
    }
}
