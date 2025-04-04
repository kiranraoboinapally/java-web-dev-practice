package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.MyService;

@RestController
@RequestMapping("/")
public class MyController {
	@Autowired
	MyService service;
	@GetMapping("/m1")
	public String m1()
	{
		return service.m1();
	}
	@GetMapping("/add/{num1}/{num2}")
	public int add(@PathVariable int num1,@PathVariable int num2)
	{
		return service.add(num1,num2);
	}
}
