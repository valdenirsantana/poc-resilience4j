package br.com.valdenirsantana.pocresilience4j.service;

import br.com.valdenirsantana.pocresilience4j.client.ShippingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    ShippingClient shippingClient;

    public String getShipping() {
        return shippingClient.getShipping().getBody();
    }

}
