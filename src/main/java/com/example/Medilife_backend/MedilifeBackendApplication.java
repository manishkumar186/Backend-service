package com.example.Medilife_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MedilifeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilifeBackendApplication.class, args);
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/medilife/**")
					.allowedOrigins("*")
					.allowedMethods("*")
					.allowedHeaders("*");

		}
	}

}
