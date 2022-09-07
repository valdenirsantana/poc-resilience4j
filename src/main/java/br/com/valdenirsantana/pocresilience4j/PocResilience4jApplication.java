package br.com.valdenirsantana.pocresilience4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PocResilience4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocResilience4jApplication.class, args);
	}

}
