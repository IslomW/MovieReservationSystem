package com.sharipov.movie_reservation_system.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtDTO {
    private String username;
    private String role;
}
