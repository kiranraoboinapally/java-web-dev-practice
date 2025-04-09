package com.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Student;
import com.demo.Service.ServiceInterface;

@RestController
@RequestMapping("/student")
public class MyController {
	@Autowired
	private ServiceInterface service;

	@PostMapping("/")
	public String save(@RequestBody Student student)
	{
		return service.save(student);
	}
	@GetMapping("/{roll}")
	public String findById(@PathVariable int roll)
	{
		return service.findById(roll);
	}
	@GetMapping("/")
	public List<Student> findAll()
	{
		return service.findAll();
	}
}
