package com.sharipov.movie_reservation_system.domain.web.dto;
import com.sharipov.movie_reservation_system.domain.entity.movie.Genre;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
public class MovieDTO {
    private String title;
    private String description;
//    private String posterImg;

    private Set<Genre> genres;

}
