package com.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@CrossOrigin(origins = "http://localhost:3000")
	 @GetMapping("/api/hello")
	    public String sayHello() {
	        return "Hello from Spring Boot!";
	 }
	@GetMapping("/add/{num1}/{num2}")
	public int add(@PathVariable int num1,@PathVariable int num2)
	{
		return num1+num2;
	}
}
