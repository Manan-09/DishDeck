package dev.manan.dishdeck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dev.manan.dishdeck")
public class DishDeckApplication {
	public static void main(String[] args) {
		SpringApplication.run(DishDeckApplication.class, args);
	}

}
