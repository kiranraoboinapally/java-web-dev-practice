package com.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
