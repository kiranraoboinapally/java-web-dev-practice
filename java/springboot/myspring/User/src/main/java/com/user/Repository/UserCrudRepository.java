package com.user.Repository;

import org.springframework.data.repository.CrudRepository;

import com.user.Model.User;

public interface UserCrudRepository extends CrudRepository<User,Long>{

	User findByName(String Name);
}
