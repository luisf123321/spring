package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);
		System.out.println("find");
		System.out.println(repository.count());

		// crear un coche
		Coche toyota = new Coche(null, "prios","toyota",2020L);
		repository.save(toyota);

		//recuperar un coche
		System.out.println(repository.findAll());
	}

}
