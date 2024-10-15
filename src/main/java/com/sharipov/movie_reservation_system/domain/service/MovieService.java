package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovieById(Long id);

    Profile getMovieById(Long id);

    Profile create(Movie movie);

    Boolean update(Movie movie);

    void deleteById(Long id);
}
