package com.platzi.platzi_play.persistence;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play.domain.exception.MovieAlreadyExistsException;
import com.platzi.platzi_play.domain.repository.MovieRepository;
import com.platzi.platzi_play.persistence.crud.CrudMovieEntity;
import com.platzi.platzi_play.persistence.entity.MovieEntity;
import com.platzi.platzi_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        return this.crudMovieEntity.findById(id)
                .map(this.movieMapper::toDto)
                .orElse(null);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {

        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }

        MovieEntity entity = this.movieMapper.toEntity(movieDto);
        entity.setEstado("D");
        return this.movieMapper.toDto(this.crudMovieEntity.save(entity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) return null;

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity != null) {
            movieEntity.setEstado("N");
            this.crudMovieEntity.save(movieEntity);
        }
    }
}
