package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.config.MailType;
import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.service.MailService;
import freemarker.template.Configuration;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final Configuration configuration;
    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(Profile profile, MailType mailType, Properties params) {

        switch (mailType) {
            case REGISTRATION -> sendRegistrationEmail(profile, params);
            default -> {
            }
        }
    }


    @SneakyThrows
    private void sendRegistrationEmail(Profile profile, Properties params) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
        helper.setSubject("Thank you for registration " + profile.getName());
        helper.setTo(profile.getUsername());
        String emailContent = getRegistrationContent(profile, params);
        helper.setText(emailContent, true);
        mailSender.send(message);
    }


    @SneakyThrows
    private String getRegistrationContent(Profile profile, Properties params) {
        StringWriter writer = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("name", profile.getName());
        configuration.getTemplate("register.ftlh")
                .process(model, writer);
        return writer.getBuffer().toString();
    }
}
