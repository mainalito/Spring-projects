package io.javabrains.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.web.bind.annotation.RestController;

@RestController //for rest api classes //provides http responses
public class HelloController {

	@RequestMapping("/hello") //this is only for GET request 
	public String sayHi() {
		return "hello";
	}
}
