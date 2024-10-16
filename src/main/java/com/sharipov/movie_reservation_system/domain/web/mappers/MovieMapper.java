package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import org.springframework.stereotype.Component;


@Component
public class MovieMapper {

    public Movie movieDTOToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setGenres(dto.getGenres());
        return movie;
    }

    public MovieDTO movieEntityToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setGenres(movie.getGenres());
        return dto;
    }

}
