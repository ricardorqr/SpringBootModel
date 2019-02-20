package com.springBootModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.springBootModel.model.Cart;

@SpringBootApplication
//@ComponentScan(basePackageClasses = {Cart.class})
public class SpringBootModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootModelApplication.class, args);
	}

}
