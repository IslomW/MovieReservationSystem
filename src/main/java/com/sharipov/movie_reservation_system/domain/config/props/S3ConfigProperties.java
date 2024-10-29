package com.sharipov.movie_reservation_system.domain.config.props;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.aws.s3")
public class S3ConfigProperties {
    private String bucketName;
    private String accessKey;
    private String secretKey;
    private String region;
}
