package com.Fawry.MovieApplication.service.movie;

import com.Fawry.MovieApplication.dto.Movie.MovieOMDBAPI;
import com.Fawry.MovieApplication.dto.Movie.MovieRequest;
import com.Fawry.MovieApplication.dto.Movie.MovieRetrieval;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {
     void addMovie(MovieRequest movieRequest);
     MovieRetrieval getMovieById(int id);
     void deleteMovieById(int id);
     void updateMovie(int id, MovieRequest movieRequest);
     List<MovieRetrieval> getAllMovies();
     List<MovieOMDBAPI> getMovies(String title);
     Page<MovieRetrieval> getAllMoviesByPagination(int page,int size);
     Page<MovieOMDBAPI> getMoviesByPagination(int page, int size, String title);
}
