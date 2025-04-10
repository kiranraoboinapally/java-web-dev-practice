package com.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.Model.User;

public interface UserJpaRepository extends JpaRepository<User,Long> {


}
