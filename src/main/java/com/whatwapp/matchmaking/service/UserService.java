package com.whatwapp.matchmaking.service;

import java.util.List;

import com.whatwapp.matchmaking.dto.UserDTO;
import com.whatwapp.matchmaking.model.User;

public interface UserService {

	List<User> findAll();

	User findById(String id);

	UserDTO save(User user);

	boolean delete(String id);

	UserDTO convert2DTO(User user);

	User convert2Entity(UserDTO userDTO);

}
