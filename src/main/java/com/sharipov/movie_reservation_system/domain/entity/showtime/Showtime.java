package com.sharipov.movie_reservation_system.domain.entity.showtime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Schema(hidden = true)
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String time;
    private String cinema_hall;
    private Integer capacity;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime createdAt;

    @Column(name = "movie_id")
    private Long movieId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", updatable = false, insertable = false)
    private Movie movie;

}
