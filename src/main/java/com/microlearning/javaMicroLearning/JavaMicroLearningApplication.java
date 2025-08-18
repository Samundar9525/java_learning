package com.microlearning.javaMicroLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class JavaMicroLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMicroLearningApplication.class, args);
	}

}
