package com.sharipov.movie_reservation_system.domain.web.dto;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import lombok.Data;



@Data
public class ShowtimeDTO {
    private String date;
    private String time;
    private String cinema_hall;
    private Integer capacity;

    private Long movie_id;

    private Movie movie;
}
