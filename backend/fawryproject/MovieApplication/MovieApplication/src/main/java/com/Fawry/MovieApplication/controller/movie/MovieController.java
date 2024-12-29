package com.Fawry.MovieApplication.controller.movie;

import com.Fawry.MovieApplication.dto.Movie.MovieOMDBAPI;
import com.Fawry.MovieApplication.dto.Movie.MovieRequest;
import com.Fawry.MovieApplication.dto.Movie.MovieRetrieval;
import com.Fawry.MovieApplication.service.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "movie controller")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/addMovie")
    @Operation(description = "create movie")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> createMovie(@RequestBody MovieRequest movieRequest) {
        movieService.addMovie(movieRequest);
        return new ResponseEntity<>("Movie Created Successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getMovie/{id}")
    @Operation(description = "get movie")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<MovieRetrieval> getMovie(@PathVariable int id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMovie/{id}")
    @Operation(description = "delete movie")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("Movie Deleted Successfully", HttpStatus.NO_CONTENT);

    }

    @GetMapping("/getAllMovies")
    @Operation(description = "get all movies")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<MovieRetrieval>> getAllMovies() {

        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);

    }
    @GetMapping("/getAllPaginatedMovies")
    @Operation(description = "get all movies using pagination")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Page<MovieRetrieval>> getAllPaginatedMovies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {

        return new ResponseEntity<>(movieService.getAllMoviesByPagination(page,size), HttpStatus.OK);

    }

    @GetMapping("/getAllPaginatedMoviesFromOMDB")
    @Operation(description = "get  movies from omdb api using pagination")
    @CrossOrigin(origins = "http://localhost:4200")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<MovieOMDBAPI>> getAllPaginatedMovies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam String title) {

        return new ResponseEntity<>(movieService.getMoviesByPagination(page,size,title), HttpStatus.OK);

    }

    @PutMapping("/updateMovie/{id}")
    @Operation(description = "update movie")
    public ResponseEntity<String> updateMovie(@RequestBody MovieRequest movieRequest, @PathVariable int id) {
        movieService.updateMovie(id, movieRequest);
        return new ResponseEntity<>("Movie Updated Successfully", HttpStatus.CREATED);
    }

    @GetMapping("getMovies")
    @Operation(description = "get  movies from the OMDB API")
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<MovieOMDBAPI>> getMoviesFromOMDBAPI(@RequestParam String title) {

        return new ResponseEntity<>(movieService.getMovies(title), HttpStatus.OK);

    }
}
