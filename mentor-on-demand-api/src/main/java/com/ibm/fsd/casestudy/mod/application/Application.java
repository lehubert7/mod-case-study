package com.ibm.fsd.casestudy.mod.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ibm.fsd.casestudy.mod.jpa.repo"})
@EntityScan(basePackages = "com.ibm.fsd.casestudy.mod.jpa.entity")
@ComponentScan({
	"com.ibm.fsd.casestudy.mod.controller",
	"com.ibm.fsd.casestudy.mod.service",
	"com.ibm.fsd.casestudy.mod.config"
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
