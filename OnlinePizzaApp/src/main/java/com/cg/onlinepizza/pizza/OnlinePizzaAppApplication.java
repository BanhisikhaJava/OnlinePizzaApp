package com.cg.onlinepizza.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cg.onlinepizza.pizza.controller.IPizzaController;
import com.cg.onlinepizza.pizza.dao.IPizzaRepositoryDao;

@SpringBootApplication



public class OnlinePizzaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePizzaAppApplication.class, args);
		System.out.println("Yayy Spring Started");
	}

}
