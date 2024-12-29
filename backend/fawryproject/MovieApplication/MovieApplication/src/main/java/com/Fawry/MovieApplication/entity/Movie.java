package com.Fawry.MovieApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    @NotNull(message = "title should not be null")
    @NotEmpty(message = "title should not be empty")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "genre")
    private String genre;
    @Column(name = "director")
    private String director;
    @Column(name = "year")
    private String year;
    @Column(name = "poster")
    private String poster;



}
