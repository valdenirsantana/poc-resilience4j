package br.com.valdenirsantana.pocresilience4j.controller;

import br.com.valdenirsantana.pocresilience4j.service.ShippingService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping(value = "/shipping")
    @Retry(name = "shippingRetry", fallbackMethod = "shippingFallback")
    public ResponseEntity<String> getShipping(){
        String response = shippingService.getShipping();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> shippingFallback(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
