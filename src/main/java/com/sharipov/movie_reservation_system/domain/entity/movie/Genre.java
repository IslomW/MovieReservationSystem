package com.sharipov.movie_reservation_system.domain.entity.movie;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "genres")
public class Genre {
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;
}
