package com.sharipov.movie_reservation_system.domain.web.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthDTO {
    @NotNull(
            message = "Username must be not null."
    )
    private String username;

    @NotNull(
            message = "Password must be not null."
    )
    private String password;
}
