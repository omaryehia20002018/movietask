package com.Fawry.MovieApplication.service.movie;

import com.Fawry.MovieApplication.Mapper.MovieMapper;
import com.Fawry.MovieApplication.dto.Movie.MovieOMDBAPI;
import com.Fawry.MovieApplication.dto.Movie.MovieRequest;
import com.Fawry.MovieApplication.dto.Movie.MovieRetrieval;
import com.Fawry.MovieApplication.dto.Movie.OMDBResponse;
import com.Fawry.MovieApplication.entity.Movie;
import com.Fawry.MovieApplication.repository.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private final RestTemplate restTemplate;
    @Value("${omdb.api.url}")
    private String apiUrl;

    public MovieServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${omdb.api.key}")
    private String apiKey;


    @Override
    public void addMovie(MovieRequest movieRequest) {
        Movie movie = movieMapper.toMovie(movieRequest);
        movieRepository.save(movie);
    }

    @Override
    public MovieRetrieval getMovieById(int id) {
        movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("no movie with this id"));
        return movieMapper.toMovieRetrieval(movieRepository.findById(id).get());
    }

    @Override
    public void deleteMovieById(int id) {
        movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("no movie with this id to delete"));
        movieRepository.deleteById(id);

    }

    @Override
    public void updateMovie(int id, MovieRequest movieRequest) {
        Movie theMovie = movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("no movie with this id"));
        Movie movie = movieMapper.toMovie(movieRequest);
        if (movieRequest.getDirector() != null) {
            theMovie.setDirector(movieRequest.getDirector());
        }
        if (movieRequest.getPoster() != null) {
            theMovie.setPoster(movieRequest.getPoster());
        }
        if (movieRequest.getTitle() != null) {
            theMovie.setTitle(movieRequest.getTitle());
        }
        if (movieRequest.getYear() != null) {
            theMovie.setYear(movieRequest.getYear());
        }
        if (movieRequest.getGenre() != null) {
            theMovie.setGenre(movieRequest.getGenre());
        }
        if (movieRequest.getDescription() != null) {
            theMovie.setDescription(movieRequest.getDescription());
        }
        movieRepository.save(theMovie);
    }

    @Override
    public List<MovieRetrieval> getAllMovies() {
        return movieRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(movie -> movieMapper.toMovieRetrieval(movie))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieOMDBAPI> getMovies(String title) {
        String url = String.format("%s/?s=%s&apikey=%s", apiUrl, title, apiKey);
        return restTemplate.getForObject(url, OMDBResponse.class).getMovieOMDBAPIS();
    }

    @Override
    public Page<MovieOMDBAPI> getMoviesByPagination(int page, int size,String title) {

        String url = String.format("%s/?s=%s&apikey=%s", apiUrl, title, apiKey);
        OMDBResponse response = restTemplate.getForObject(url, OMDBResponse.class);
        List<MovieOMDBAPI> movieOMDBAPIS = response.getMovieOMDBAPIS();
        int start = page * size;
        if (start >= movieOMDBAPIS.size()) {
            return new PageImpl<>(Collections.emptyList(), PageRequest.of(page, size), movieOMDBAPIS.size());
        }
        int end = Math.min(start + size, movieOMDBAPIS.size());
        List<MovieOMDBAPI> paginatedMovies = movieOMDBAPIS.subList(start, end);
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(paginatedMovies, pageable, movieOMDBAPIS.size());
    }

    @Override
    public Page<MovieRetrieval> getAllMoviesByPagination(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Movie> movies= movieRepository.findAll(pageable);
        List<MovieRetrieval> movieRetrievals = movies.getContent().stream()
                .map(movieMapper::toMovieRetrieval)
                .collect(Collectors.toList());

        return new PageImpl<>(movieRetrievals, pageable, movies.getTotalElements());
    }
}
