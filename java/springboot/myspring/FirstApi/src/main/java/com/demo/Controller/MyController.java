package com.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Calculater")
public class MyController {
	@GetMapping("/sub")
	public int sub() {
		return 10-20;
	}
	@GetMapping("/add")
	public int add() {
		return 10+20;
	}
	@GetMapping("/mul")
	public int mul() {
		return 10*20;
	}
	@GetMapping("/div")
	public int div() {
		return 10/20;
	}
}
