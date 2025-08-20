package com.platzi.platzi_play.domain.service;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll()
    {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(Long id)
    {
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto) {
        if (movieDto == null) {
            throw new IllegalArgumentException("MovieDto cannot be null");
        }
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        if (updateMovieDto == null) {
            throw new IllegalArgumentException("updateMovieDto cannot be null");
        }
        return this.movieRepository.update(id, updateMovieDto);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this.movieRepository.delete(id);
    }
}
