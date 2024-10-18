package com.sharipov.movie_reservation_system.domain.web.dto;

import com.sharipov.movie_reservation_system.domain.entity.profile.Role;
import lombok.Data;


@Data
public class ProfileDTO {
    private String name;
    private String username;
    private String password;
    private String confirmationPassword;
    private Role role;
    private String accessToken;
    private String refreshToken;

}
