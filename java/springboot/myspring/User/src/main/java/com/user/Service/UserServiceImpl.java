package com.user.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.user.Exception.UserNotFoundException;
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
        // Save a new user
        return userCrudRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        // Find a user by name
        User user = userCrudRepository.findByName(name);
        if (user == null) {
            throw new UserNotFoundException("User with name '" + name + "' does not exist.");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        // Find all users, sorted by email in descending order
        return (List<User>) userJpaRepository.findAll(Sort.by("email").descending());
    }

    @Override
    public User update(Long id, User user) {

        Optional<User> existingUserOpt = userCrudRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userCrudRepository.save(existingUser);
        } else {
            throw new UserNotFoundException("User with ID " + id + " does not exist.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<User> existingUserOpt = userCrudRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            userCrudRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with ID " + id + " does not exist.");
        }
    }

	@Override
	public List<User> myPagination() {
	PageRequest pagerequest=PageRequest.of(1, 2);
	Page<User> page=userJpaRepository.findAll(pagerequest);
	return page.toList();
	}
}