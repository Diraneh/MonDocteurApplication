package org.poeiscrumproject.gp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class MonDocteurApplication extends SpringBootServletInitializer{
	
	//Override nécessaire pour packager en war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(MonDocteurApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MonDocteurApplication.class, args);
	}
}
