package com.sharipov.movie_reservation_system.domain.web.controller;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.service.MovieService;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.MovieMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
@Tag(
        name = "Movie Controller",
        description = "Movie API"
)
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping
    @Operation(summary = "Get all movies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        List<MovieDTO> movieDTOS = mapper.movieListToDTOS(movies);
        return ResponseEntity.ok(movieDTOS);

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get movie by id")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        MovieDTO dto = MovieMapper.movieEntityToDTO(movie);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Create movie.(Only Admins)")
    public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) {
        Movie movie = MovieMapper.movieDTOToEntity(movieDTO);
        movieService.create(movie);
        MovieDTO dto = MovieMapper.movieEntityToDTO(movie);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Update movie.(Only Admins)")
    public ResponseEntity<Boolean> update(@RequestBody MovieDTO movieDTO,
                                          @PathVariable Long id) {
        Boolean result = movieService.update(movieDTO, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete movie by id.(Only Admins)")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
