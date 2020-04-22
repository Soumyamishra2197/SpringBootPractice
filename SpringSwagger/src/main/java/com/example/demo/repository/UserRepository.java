package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface  UserRepository extends MongoRepository<User, String> {
	
	@Query(value = "{'username':?0,'password':?1}")
	public User loginUser(String username,String password);
	
}
