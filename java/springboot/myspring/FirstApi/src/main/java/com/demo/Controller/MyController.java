package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.MyService;

@RestController
public class MyController {
	@Autowired
	MyService service;
	@GetMapping("/m1")
	public String m1()
	{
		return service.m1();
	}
	
}
