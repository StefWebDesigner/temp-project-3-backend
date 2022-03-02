package com.revature.dartcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.revature.models")
@EnableJpaRepositories("com.revature.repositories")
@SpringBootApplication(scanBasePackages = "com.revature")
public class DartCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(DartCartApplication.class, args);
	}

}
