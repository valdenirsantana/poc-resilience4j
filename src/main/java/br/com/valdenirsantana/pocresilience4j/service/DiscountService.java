package br.com.valdenirsantana.pocresilience4j.service;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public String getDiscount() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return "Discount successfully applied";
    }
}
