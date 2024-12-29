package com.Fawry.MovieApplication.repository.rate;

import com.Fawry.MovieApplication.entity.MovieRateId;
import com.Fawry.MovieApplication.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate, MovieRateId> {

    Rate findByMovieRateId(MovieRateId movieRateId);


    void deleteByMovieRateId(MovieRateId movieRateId);

}
