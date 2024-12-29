package com.Fawry.MovieApplication.service.rate;

import com.Fawry.MovieApplication.Mapper.RateMapper;
import com.Fawry.MovieApplication.dto.Rate.RateCreateRequest;
import com.Fawry.MovieApplication.dto.Rate.RateRetrievalRequest;
import com.Fawry.MovieApplication.entity.MovieRateId;
import com.Fawry.MovieApplication.entity.Rate;
import com.Fawry.MovieApplication.repository.rate.RateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RateServiceImp implements RateService{
    @Autowired
    private RateMapper rateMapper;
    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<RateRetrievalRequest> getAllRates() {
        return rateRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(rate -> rateMapper.toRateRetrievalRequest(rate))  // Use the instance here
                .collect(Collectors.toList());
    }

    @Override
    public void addRate(RateCreateRequest rateCreateRequest) {
        Rate rate = rateMapper.toRate(rateCreateRequest);
        rateRepository.save(rate);
    }

    @Override
    public RateRetrievalRequest getRateByUserIdAndMovieId(int userId, int movieId) {
        MovieRateId movieRateId=new MovieRateId();
        movieRateId.setUserId(userId);
        movieRateId.setMovieId(movieId);
        Optional.of(rateRepository.findByMovieRateId(movieRateId)).orElseThrow(()->new NoSuchElementException("no movie with this user id and movie id to get"));
     return   rateMapper.toRateRetrievalRequest(rateRepository.findByMovieRateId(movieRateId));
    }

    @Override
    @Transactional
    public void deleteRateByUserIdAndMovieId(int userId, int movieId) {
        MovieRateId movieRateId=new MovieRateId();
        movieRateId.setUserId(userId);
        movieRateId.setMovieId(movieId);
        Rate byMovieRateId = rateRepository.findByMovieRateId(movieRateId);
        Optional.of(rateRepository.findByMovieRateId(movieRateId)).orElseThrow(()->new NoSuchElementException("no movie with this user id and movie id to get"));
        rateRepository.deleteByMovieRateId(movieRateId);
    }


}
