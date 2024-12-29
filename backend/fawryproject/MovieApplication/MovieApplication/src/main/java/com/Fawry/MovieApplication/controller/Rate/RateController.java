package com.Fawry.MovieApplication.controller.Rate;


import com.Fawry.MovieApplication.dto.Rate.RateCreateRequest;
import com.Fawry.MovieApplication.dto.Rate.RateRetrievalRequest;
import com.Fawry.MovieApplication.service.rate.RateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rate")
@Tag(name = "rate controller")

public class RateController {
    @Autowired
    private RateService rateService;
    @PostMapping("/addRate")
    @Operation(description = "add rate for movie")

    public ResponseEntity<String> createRate(@RequestBody RateCreateRequest rateCreateRequest){

        rateService.addRate(rateCreateRequest);
        return new ResponseEntity<>("Rate Created Successfully", HttpStatus.CREATED);
    }
    @GetMapping("/getRate/{userId}/{movieId}")
    @Operation(description = "get rate for a certain movie and certain user")
    public ResponseEntity<RateRetrievalRequest> getRate(@PathVariable int userId, @PathVariable int movieId){
        return new ResponseEntity<>(rateService.getRateByUserIdAndMovieId(userId,movieId), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteRate/{userId}/{movieId}")
    @Operation(description = "delete rate for a certain movie and certain user")
    public ResponseEntity<String> deleteRate(@PathVariable int userId, @PathVariable int movieId){
          rateService.deleteRateByUserIdAndMovieId(userId,movieId);
        return new ResponseEntity<>("Rate Deleted Successfully" , HttpStatus.CREATED);

    }
    @GetMapping("/getAll")
    @Operation(description = "get all rates")
    public ResponseEntity <List<RateRetrievalRequest>> getAllRates(){

        return new ResponseEntity<>(rateService.getAllRates(), HttpStatus.CREATED);

    }

}
