package com.Fawry.MovieApplication.Mapper;

import com.Fawry.MovieApplication.dto.Rate.RateCreateRequest;
import com.Fawry.MovieApplication.dto.Rate.RateRetrievalRequest;
import com.Fawry.MovieApplication.entity.Rate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateMapper {
    Rate toRate(RateCreateRequest rateCreateRequest);
    RateRetrievalRequest toRateRetrievalRequest(Rate therate);
}
