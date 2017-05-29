package com.distribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class EjemploJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(EjemploJpaApplication.class, args);
	}
}
