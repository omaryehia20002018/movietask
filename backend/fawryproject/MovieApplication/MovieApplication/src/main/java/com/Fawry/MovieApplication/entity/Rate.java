package com.Fawry.MovieApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rate implements Serializable {
    @EmbeddedId
    private MovieRateId movieRateId;
    @Column(name = "rate")
    private Integer rate;
}
