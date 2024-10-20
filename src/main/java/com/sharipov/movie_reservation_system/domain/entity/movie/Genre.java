package com.sharipov.movie_reservation_system.domain.entity.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "genres")
@Schema(hidden = true)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
