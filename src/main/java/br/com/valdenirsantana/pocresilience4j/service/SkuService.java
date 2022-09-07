package br.com.valdenirsantana.pocresilience4j.service;

import br.com.valdenirsantana.pocresilience4j.client.SkuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuService {

    @Autowired
    SkuClient skuClient;

    public String getSku() {
        return skuClient.getSku().getBody();
    }

    public String getSkuFromCache() {
        return "{\"id\":\"SKU0123456789\",\"price\":100,\"available\":true,\"details\":\"ERROR on call Partner - This is a cached value \"}";
    }
}
