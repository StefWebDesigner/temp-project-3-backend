package com.revature.dartcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DartCartApplication {

	public static ApplicationContext app;

	public static void main(String[] args) {
		app = SpringApplication.run(DartCartApplication.class, args);
	}

}
