package com.Fawry.MovieApplication.dto.Rate;

import com.Fawry.MovieApplication.entity.MovieRateId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateRetrievalRequest {
    MovieRateId movieRateId;
    private Integer rate;
}
