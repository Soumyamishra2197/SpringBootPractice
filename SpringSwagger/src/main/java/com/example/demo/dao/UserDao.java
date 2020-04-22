package com.example.demo.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Component
public class UserDao {
	@Autowired
	UserRepository repository;
	
	public Collection<User> getUser(){
		return repository.findAll();
	}
	public User saveUser(User user) {
		return repository.insert(user);
	}
	public User loginUser(String username,String password) {
		User user=repository.loginUser(username, password);
		return user;
	}
	
}
