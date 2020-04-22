package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
	
	public User saveUser(User user) {
		
		User u=userService.saveUser(user);
		return u;
		
	}
	@GetMapping("/userDetails")
	public Collection<User> getUser(){
		return userService.getUser();
	}
	
	
}



