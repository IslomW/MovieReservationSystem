package com.sharipov.movie_reservation_system.domain.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharipov.movie_reservation_system.domain.entity.profile.Role;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmationPassword;
    private Role role;
    private String accessToken;
    private String refreshToken;

}
