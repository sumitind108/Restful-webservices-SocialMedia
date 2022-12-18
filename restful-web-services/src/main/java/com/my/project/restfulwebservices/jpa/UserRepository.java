package com.my.project.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.project.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
