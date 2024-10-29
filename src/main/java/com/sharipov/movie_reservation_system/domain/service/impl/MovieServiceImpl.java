package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.entity.movie.Genre;
import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.MovieRepository;
import com.sharipov.movie_reservation_system.domain.service.ImageService;
import com.sharipov.movie_reservation_system.domain.service.MovieService;
import com.sharipov.movie_reservation_system.domain.util.SpringSecurityUtil;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final ImageService imageService;

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        return movies;

    }


    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not Found."));
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Boolean update(MovieDTO movieDTO, Long movieId) {
        Movie exist = getMovieById(movieId);
        exist.setTitle(movieDTO.getTitle());
        exist.setDescription(movieDTO.getDescription());
        if (movieDTO.getGenres() != null){
            exist.setGenres(movieDTO.getGenres());
        }
        movieRepository.save(exist);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void uploadImage(Long id, MultipartFile multipartFile) throws IOException {
        String fileName = imageService.uploadImage(multipartFile);
        Movie movie = getMovieById(id);
        movie.setPosterImg(fileName);
        movieRepository.save(movie);
    }

}
