package com.revature.dartcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.revature")
public class DartCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(DartCartApplication.class, args);
	}

}
