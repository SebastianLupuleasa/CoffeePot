package com.lupuleasa.coffee;

import com.lupuleasa.coffee.repositories.CustomerRepository;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class CoffeeApplication {

	@Value("${stripe.api.key}")
	private String stripeApiKey;

	@PostConstruct
	public void setup()
	{
		// This is your real test secret API key.
		Stripe.apiKey = stripeApiKey;
	}

	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);
	}

}
