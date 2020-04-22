package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JwtUser;
import com.example.demo.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	@PostMapping
	
	public String generate(@RequestBody final JwtUser jwtUser) {
		
		JwtGenerator jwtGenerator=new JwtGenerator();
		String g= jwtGenerator.generate(jwtUser);
		return g;
	}
}
