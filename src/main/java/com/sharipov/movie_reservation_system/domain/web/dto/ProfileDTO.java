package com.sharipov.movie_reservation_system.domain.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharipov.movie_reservation_system.domain.entity.profile.Role;
import com.sharipov.movie_reservation_system.domain.web.dto.validation.OnCreate;
import com.sharipov.movie_reservation_system.domain.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    @NotNull(
            message = "Name must be not null.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Length(
            max = 255,
            message = "Name length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String name;

    @NotNull(
            message = "Username must be not null.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Length(
            max = 255,
            message = "Username length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;

    @NotNull(
            message = "Password must be not null.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(
            message = "Password confirmation must be not null.",
            groups = {OnCreate.class}
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmationPassword;
    private Role role;
    private String accessToken;
    private String refreshToken;

}
