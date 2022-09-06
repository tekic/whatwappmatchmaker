package com.whatwapp.matchmaking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.whatwapp.matchmaking.model.User;

public interface UserMongoRepository extends MongoRepository<User, String> {
	
	public List<User> findByLastName(String lastName);
	public List<User> findByFirstName(String firstName);
	public List<User> findAllByOrderByBirthDateAsc();
	
}
