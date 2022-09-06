package com.whatwapp.matchmaking.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whatwapp.matchmaking.dto.UserDTO;
import com.whatwapp.matchmaking.model.User;
import com.whatwapp.matchmaking.repository.UserMongoRepository;
import com.whatwapp.matchmaking.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMongoRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAllByOrderByBirthDateAsc();
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(id).get();
	}

	@Override
	public UserDTO save(User user) {
		return convert2DTO(userRepository.save(user));
	}

	@Override
	public boolean delete(String id) {
		User user = userRepository.findById(id).get();
		boolean deleted = false;
		if (user != null) {
			userRepository.delete(user);
			deleted = false;
		}

		return deleted;
	}

	@Override
	public UserDTO convert2DTO(User user) {
		UserDTO cdto = new UserDTO();
		if (user != null) {
			cdto = new UserDTO(user);
		}
		return cdto;
	}

	@Override
	public User convert2Entity(UserDTO userDTO) {
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setBirthDate(userDTO.getBirthDate());
		user.setCreated(new Date());

		return user;
	}

}
