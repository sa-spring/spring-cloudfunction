package com.example.cloudfunction;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class CloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFunctionApplication.class, args);
	}

	@Bean
    public Function<String, String> reverseString() {
        return value -> new StringBuilder(value).reverse().toString();
	}
	
	@Bean
	public Function<Flux<String>, Flux<String>> uppercase() {
	  return flux -> flux.map(value -> value.toUpperCase());
	}
}
