package com.Fawry.MovieApplication.Mapper;

import com.Fawry.MovieApplication.dto.Rate.RateCreateRequest;
import com.Fawry.MovieApplication.dto.Rate.RateRetrievalRequest;
import com.Fawry.MovieApplication.entity.Rate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-29T14:18:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class RateMapperImpl implements RateMapper {

    @Override
    public Rate toRate(RateCreateRequest rateCreateRequest) {
        if ( rateCreateRequest == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setMovieRateId( rateCreateRequest.getMovieRateId() );
        rate.setRate( rateCreateRequest.getRate() );

        return rate;
    }

    @Override
    public RateRetrievalRequest toRateRetrievalRequest(Rate therate) {
        if ( therate == null ) {
            return null;
        }

        RateRetrievalRequest rateRetrievalRequest = new RateRetrievalRequest();

        rateRetrievalRequest.setMovieRateId( therate.getMovieRateId() );
        rateRetrievalRequest.setRate( therate.getRate() );

        return rateRetrievalRequest;
    }
}
