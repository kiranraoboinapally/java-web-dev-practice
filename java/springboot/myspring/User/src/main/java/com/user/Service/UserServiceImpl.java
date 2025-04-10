package com.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.user.Model.User;
import com.user.Repository.UserCrudRepository;
import com.user.Repository.UserJpaRepository;
@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired
	private UserCrudRepository userCrudRepository;
	@Override
	public User save(User user) {
		return userCrudRepository.save(user);
	}
	@Override
	public User findByName(String name) {
		
		return userCrudRepository.findByName(name);
	}
	@Override
	public List<User> findAll() {
		return (List<User>) userJpaRepository.findAll(Sort.by("email").descending());
	}

}
