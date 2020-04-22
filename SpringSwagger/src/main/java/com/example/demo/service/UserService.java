package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public Collection<User> getUser(){
		return userDao.getUser();
	}
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public User loginUser(String username,String password) {
		return userDao.loginUser(username, password);
	}
}
