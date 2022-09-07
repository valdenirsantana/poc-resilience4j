package br.com.valdenirsantana.pocresilience4j.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "skuClient", url = "localhost:8001")
public interface SkuClient {

        @GetMapping("/sku")
        ResponseEntity<String> getSku();

}
