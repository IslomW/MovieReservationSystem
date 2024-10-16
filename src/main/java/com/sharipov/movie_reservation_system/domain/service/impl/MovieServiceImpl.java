package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.entity.movie.Genre;
import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.MovieRepository;
import com.sharipov.movie_reservation_system.domain.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
       return movies;

    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie not Found."));
    }

    @Override
    public Movie create(Movie movie) {
//        List<Genre> genres = (List<Genre>) movie.getGenres();
//        movie.setGenres(null);
//        movieRepository.save(movie);
//
        return movieRepository.save(movie);
    }

    @Override
    public Boolean update(Movie movie) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
