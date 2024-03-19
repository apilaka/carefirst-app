package com.carefirst.carefirstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//(exclude ={ SecurityAutoConfiguration.class })
@ComponentScan("com.carefirst.carefirstapp")
@EnableAutoConfiguration
public class CarefirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarefirstAppApplication.class, args);
	}

}
//http://localhost:8761/swagger-ui/index.html