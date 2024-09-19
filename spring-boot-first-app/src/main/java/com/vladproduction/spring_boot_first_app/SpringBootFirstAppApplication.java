package com.vladproduction.spring_boot_first_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFirstAppApplication {

	@Bean
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBootFirstAppApplication.class, args);

		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		System.out.println(helloWorld.helloWorld()); //Hello World!!!

		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

	}

}
