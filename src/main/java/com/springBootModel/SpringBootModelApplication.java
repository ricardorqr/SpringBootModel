package com.springBootModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootModelApplication.class, args);
	}

}
