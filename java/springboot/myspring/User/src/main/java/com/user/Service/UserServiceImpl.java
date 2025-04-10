package com.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Model.User;
import com.user.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	@Override
	public User findByName(String name) {
		
		return userRepository.findByName(name);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

}
