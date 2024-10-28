package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.config.MailType;
import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;

import java.util.Map;
import java.util.Properties;

public interface MailService {
    void sendEmail(Profile profile, MailType mailType, Properties params);
}
