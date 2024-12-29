package com.Fawry.MovieApplication.dto.Rate;

import com.Fawry.MovieApplication.entity.MovieRateId;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateCreateRequest {

    MovieRateId movieRateId;
    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;
}
