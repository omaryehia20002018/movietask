package com.Fawry.MovieApplication.dto.Movie;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class MovieRequest {
    private int id;
    @NotNull(message = "title cannot be null")
    private String title;
    private String description;
    private String genre;
    private String director;
    private String year;
    private String poster;

}
