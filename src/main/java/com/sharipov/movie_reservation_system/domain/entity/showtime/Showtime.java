package com.sharipov.movie_reservation_system.domain.entity.showtime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String time;
    private String cinema_hall;
    private Integer capacity;
    private LocalDateTime createdAt;

    @Column(name = "movie_id")
    private Long movieId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", updatable = false, insertable = false)
    private Movie movie;

}
