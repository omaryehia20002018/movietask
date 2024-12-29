package com.Fawry.MovieApplication.Mapper;

import com.Fawry.MovieApplication.dto.Movie.MovieRequest;
import com.Fawry.MovieApplication.dto.Movie.MovieRetrieval;
import com.Fawry.MovieApplication.entity.Movie;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-29T14:18:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie toMovie(MovieRequest movieRequest) {
        if ( movieRequest == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( movieRequest.getId() );
        movie.setTitle( movieRequest.getTitle() );
        movie.setDescription( movieRequest.getDescription() );
        movie.setGenre( movieRequest.getGenre() );
        movie.setDirector( movieRequest.getDirector() );
        movie.setYear( movieRequest.getYear() );
        movie.setPoster( movieRequest.getPoster() );

        return movie;
    }

    @Override
    public MovieRetrieval toMovieRetrieval(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieRetrieval movieRetrieval = new MovieRetrieval();

        movieRetrieval.setId( movie.getId() );
        movieRetrieval.setTitle( movie.getTitle() );
        movieRetrieval.setDescription( movie.getDescription() );
        movieRetrieval.setGenre( movie.getGenre() );
        movieRetrieval.setDirector( movie.getDirector() );
        movieRetrieval.setYear( movie.getYear() );
        movieRetrieval.setPoster( movie.getPoster() );

        return movieRetrieval;
    }
}
