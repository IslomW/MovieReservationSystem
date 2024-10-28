package com.sharipov.movie_reservation_system;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;

import com.sharipov.movie_reservation_system.domain.service.MovieService;
import com.sharipov.movie_reservation_system.domain.web.controller.MovieController;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.MovieMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllMovies_ShouldReturnListOfMovies(){
        Movie movie = new Movie();
        MovieDTO movieDTO = new MovieDTO();
        when(movieService.getAllMovies()).thenReturn(Collections.singletonList(movie));
        when(movieMapper.movieListToDTOS(anyList())).thenReturn(Collections.singletonList(movieDTO));


        ResponseEntity<List<MovieDTO>> responseEntity = movieController.getAllMovies();


    }

}
