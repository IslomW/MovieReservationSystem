package com.sharipov.movie_reservation_system.domain.config;

import com.sharipov.movie_reservation_system.domain.config.props.S3ConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class S3Config {
    private final S3ConfigProperties configProperties;

    @Bean
    public S3Client s3Client() {
        log.info(configProperties.toString());
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(configProperties.getAccessKey(), configProperties.getSecretKey());
        return S3Client.builder()
                .region(Region.of(configProperties.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
    }

}
