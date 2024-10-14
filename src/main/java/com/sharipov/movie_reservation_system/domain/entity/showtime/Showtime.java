package com.sharipov.movie_reservation_system.domain.entity.showtime;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Showtime {
    private Long id;
    private String data;
    private String time;
    private String cinema_hall;
    private Integer capacity;
    private LocalDateTime createdAt;

    @Column(name = "movie_id")
    private String movieId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", updatable = false, insertable = false)
    private Movie movie;
}
