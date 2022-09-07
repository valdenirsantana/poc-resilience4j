package br.com.valdenirsantana.pocresilience4j.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ShippingClient", url = "localhost:8001")
public interface ShippingClient {

        @GetMapping("/shipping")
        ResponseEntity<String> getShipping();

}
