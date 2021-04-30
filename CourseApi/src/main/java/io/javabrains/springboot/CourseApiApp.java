package io.javabrains.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // this annotation shows is a spring boot
public class CourseApiApp {
//this is our starting point for spring boot 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// it does not need a servlet container nor server to be started
		// it requires a main method
		//we need to tell spring this will start it 
		//this static method will have the class
		SpringApplication.run(CourseApiApp.class, args);
	}

}
