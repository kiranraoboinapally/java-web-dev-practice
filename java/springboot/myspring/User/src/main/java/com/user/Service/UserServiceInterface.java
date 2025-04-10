package com.user.Service;

import java.util.List;

import com.user.Model.User;

public interface UserServiceInterface {

	User save(User user);

	User findByName(String name);

	List<User> findAll();

}
