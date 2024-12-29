package com.Fawry.MovieApplication.dto.Movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieOMDBAPI {
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Year")
    private String Year;
    @JsonProperty("Genre")
    private String Genre;
    @JsonProperty("Director")
    private String Director;
    @JsonProperty("Plot")
    private String Plot;
    @JsonProperty("Poster")
    private String Poster;

}
