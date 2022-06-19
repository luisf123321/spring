package com.example.obspringrest;

import com.example.obspringrest.entities.Laptop;
import com.example.obspringrest.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringRestApplication.class, args);

		LaptopRepository laptopRepository = (LaptopRepository)  context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null,"lg-40",400.50,"lenovo");

		laptopRepository.save(laptop);

		System.out.println(laptopRepository.findAll());

	}

}
