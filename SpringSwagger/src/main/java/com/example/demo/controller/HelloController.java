package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@Controller
public class HelloController {
	
	@Autowired
	UserService userService;
	@GetMapping("/login")
	public String loginUser(@RequestParam (name = "username") String username ,
			@RequestParam (name = "password") String password){
		String page="login.html";
		if(userService.loginUser(username,password)!=null) {
			page="home.html";
		}
		return page;
	}
}
