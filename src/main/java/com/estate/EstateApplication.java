package com.estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class EstateApplication {


	public static void main(String[] args) {
		SpringApplication.run(EstateApplication.class, args);
	}

}
