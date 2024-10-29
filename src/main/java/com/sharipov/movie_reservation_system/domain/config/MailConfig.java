package com.sharipov.movie_reservation_system.domain.config;

import com.sharipov.movie_reservation_system.domain.config.props.MailProperties;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class MailConfig {


    private final MailProperties mailProperties;

    @Bean
    public JavaMailSender mailSender(){
        log.info(mailProperties.toString());
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());
        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());
        mailSender.setJavaMailProperties(mailProperties.getProperties());
        mailSender.getJavaMailProperties();
        return mailSender;
    }
}
