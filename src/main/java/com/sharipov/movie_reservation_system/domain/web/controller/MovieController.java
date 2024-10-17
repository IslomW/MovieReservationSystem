package com.sharipov.movie_reservation_system.domain.web.controller;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.service.MovieService;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody MovieDTO movieDTO) {
        Movie movie = mapper.movieDTOToEntity(movieDTO);
        movieService.create(movie);
        return ResponseEntity.ok().body(movie);
    }

    ////Update


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
