package com.user.Service;

import java.util.List;

import com.user.Model.User;

public interface UserServiceInterface {

	User save(User user);

	User findByName(String name);

	List<User> findAll();

	User update(Long id, User user); 

	void delete(Long id);

	List<User> myPagination();
 
}
