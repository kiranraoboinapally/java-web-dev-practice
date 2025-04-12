package com.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.Model.User;
import com.user.Service.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserServiceInterface userServiceInterface;
@PostMapping("/")
public User save(@RequestBody User user) {
	return userServiceInterface.save(user);
	}
@GetMapping("/name/{name}")
public User findByName(@PathVariable String name)
{
	return userServiceInterface.findByName(name);
	}
@GetMapping("/")
public List<User> findAll() {
    return userServiceInterface.findAll();
}

@PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    return userServiceInterface.update(id, user);
}

@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Long id) {
    userServiceInterface.delete(id);
}
@GetMapping("/pagination")
public List<User> myPagination()
{
	return userServiceInterface.myPagination();}
}
