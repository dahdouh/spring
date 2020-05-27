package com.spring.consumingSOAPwebservice.springSOAPConsuming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.spring.consumingSOAPwebservice.wsdl.Client;
import com.spring.consumingSOAPwebservice.wsdl.ReservationResponse;

import nz.net.ultraq.thymeleaf.LayoutDialect;


@SpringBootApplication
@SpringBootConfiguration
@ComponentScan({"io", "com"})
public class SpringSoapConsumingApplication {

	public static void main(String[] args) {
		//SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    //templateEngine.addDialect(new LayoutDialect());
		SpringApplication.run(SpringSoapConsumingApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	  

}
