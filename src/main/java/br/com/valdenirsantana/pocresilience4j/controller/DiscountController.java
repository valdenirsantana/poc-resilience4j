package br.com.valdenirsantana.pocresilience4j.controller;

import br.com.valdenirsantana.pocresilience4j.service.DiscountService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping(value = "/discount")
    @RateLimiter(name = "discountLimiter", fallbackMethod = "discountFallback")
    public ResponseEntity<String> createOrder(){
        String response = discountService.getDiscount();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> discountFallback(Exception e){
        return new ResponseEntity<String>("Server is busy, try again later, please!", HttpStatus.SERVICE_UNAVAILABLE);
    }

}