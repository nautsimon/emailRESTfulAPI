package com.thecc.theccbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class TheccbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheccbackendApplication.class, args);
	}
}
