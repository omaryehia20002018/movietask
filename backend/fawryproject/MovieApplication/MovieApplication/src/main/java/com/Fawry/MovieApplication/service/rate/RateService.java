package com.Fawry.MovieApplication.service.rate;


import com.Fawry.MovieApplication.dto.Rate.RateCreateRequest;
import com.Fawry.MovieApplication.dto.Rate.RateRetrievalRequest;

import java.util.List;

public interface RateService {
    public void addRate(RateCreateRequest rateCreateRequest);
    public RateRetrievalRequest getRateByUserIdAndMovieId(int userId,int movieId);
    public void deleteRateByUserIdAndMovieId(int userId,int movieId);

    public List<RateRetrievalRequest> getAllRates();
}
