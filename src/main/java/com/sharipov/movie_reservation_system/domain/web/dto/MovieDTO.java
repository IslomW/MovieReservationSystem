package com.sharipov.movie_reservation_system.domain.web.dto;

import com.sharipov.movie_reservation_system.domain.entity.movie.Genre;
import com.sharipov.movie_reservation_system.domain.web.dto.validation.OnCreate;
import com.sharipov.movie_reservation_system.domain.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;


@Data
public class MovieDTO {

    @NotNull(message = "Id must be not null",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(
            max = 255,
            message = "Title length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String title;


    @NotNull(message = "Id must be not null",
            groups = {OnCreate.class, OnUpdate.class})
    @Length(
            max = 255,
            message = "Description length must be smaller than 255 symbols.",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String description;
//    private String posterImg;

    private Set<Genre> genres;

}
