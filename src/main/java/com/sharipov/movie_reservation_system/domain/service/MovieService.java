package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie create(Movie movie);

    Boolean update(MovieDTO movieDTO, Long movieId);

    void deleteById(Long id);
}
