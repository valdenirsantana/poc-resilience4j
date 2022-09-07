package br.com.valdenirsantana.pocresilience4j.controller;

import br.com.valdenirsantana.pocresilience4j.service.SkuService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping(value = "/sku")
    @CircuitBreaker(name = "skuBreaker", fallbackMethod = "skuFallback")
    public ResponseEntity<String> getSku() {
        String response = skuService.getSku();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> skuFallback(Exception e) {
        return new ResponseEntity<String>(skuService.getSkuFromCache(), HttpStatus.OK);
    }

}
