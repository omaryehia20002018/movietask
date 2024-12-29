package com.Fawry.MovieApplication.Mapper;


import com.Fawry.MovieApplication.dto.Movie.MovieRequest;
import com.Fawry.MovieApplication.dto.Movie.MovieRetrieval;
import com.Fawry.MovieApplication.entity.Movie;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie toMovie(MovieRequest movieRequest);


    MovieRetrieval toMovieRetrieval(Movie movie);


}
