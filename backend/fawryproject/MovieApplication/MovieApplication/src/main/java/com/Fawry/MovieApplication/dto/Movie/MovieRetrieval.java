package com.Fawry.MovieApplication.dto.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieRetrieval {
    private int id;
    private String title;
    private String description;
    private String genre;
    private String director;
    private String year;
    private String poster;
}
