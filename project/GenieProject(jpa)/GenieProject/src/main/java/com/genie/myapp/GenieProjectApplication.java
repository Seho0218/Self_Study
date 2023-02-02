package com.genie.myapp;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class GenieProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GenieProjectApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { return application.sources(GenieProjectApplication.class); }
}
