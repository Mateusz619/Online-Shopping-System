package com.onlineshoppingsystem.project;

import com.onlineshoppingsystem.project.data.Product;
import com.onlineshoppingsystem.project.data.User;
import com.onlineshoppingsystem.project.repository.ProductRepository;
import com.onlineshoppingsystem.project.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public ApplicationRunner init(ProductRepository productRepository, UserRepository userRepository){
		return args -> {
			productRepository.save(new Product("Laptop", "Lenovo", 1500));
			productRepository.save(new Product("Phone", "Samsung", 2500));
			productRepository.save(new Product("Printer", "Epson", 3500));
			productRepository.save(new Product("Mouse", "Logitech", 4500));
		};
	}
}
