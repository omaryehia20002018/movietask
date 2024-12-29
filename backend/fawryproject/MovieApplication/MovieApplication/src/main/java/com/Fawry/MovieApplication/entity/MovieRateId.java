package com.Fawry.MovieApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRateId {

    @Column(name = "user_id")
    private int userId;
    @Column(name = "movie_id")
    private int movieId;
}
