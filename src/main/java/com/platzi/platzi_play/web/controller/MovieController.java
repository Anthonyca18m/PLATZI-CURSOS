package com.platzi.platzi_play.web.controller;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@Tag(name = "Movies", description = "Operations related to movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    @Operation (
            summary = "Get movie by ID",
            description = "Retrieve a movie by its unique identifier",
            responses = {
                @ApiResponse(
                    responseCode = "200",description = "Movie found", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MovieDto.class))
                ),
                @ApiResponse(responseCode = "404",description = "Movie not found")
            }
        )
    public ResponseEntity<MovieDto> getById(
            @Parameter(
                description = "ID of the movie to retrieve",
                required = true,
                example = "1"
            )
            @PathVariable Long id
    ) {
        return this.service.getById(id) != null ?
                ResponseEntity.ok(this.service.getById(id)) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.add(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id,@Valid @RequestBody UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.service.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
