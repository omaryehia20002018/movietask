package com.Fawry.MovieApplication.dto.Movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class OMDBResponse {
    @JsonProperty("Search")
    private List<MovieOMDBAPI> movieOMDBAPIS;
    private int totalResults;
}
