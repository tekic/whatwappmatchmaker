package com.whatwapp.matchmaking.api;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatwapp.matchmaking.dto.UserDTO;
import com.whatwapp.matchmaking.dto.UserList;
import com.whatwapp.matchmaking.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<UserList> getAll() {
		log.info("Get all users: ");

		List<UserDTO> userList = userService.findAll().stream().map(c -> userService.convert2DTO(c))
				.collect(Collectors.toList());
		
		UserList users = new UserList();
		users.setUsers(userList);

		return new ResponseEntity<UserList>(users, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable String id) {
		log.info("Get user with id: " + id);
		return (userService.convert2DTO(userService.findById(id)) != null)
				? new ResponseEntity<UserDTO>(userService.convert2DTO(userService.findById(id)), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping()
	public ResponseEntity<UserDTO> saveUser(@RequestBody(required = true) UserDTO userDTO) {
		log.info("Create new user: " + userDTO.toString());
		UserDTO cd = userService.save(userService.convert2Entity(userDTO));
		return (cd != null) ? new ResponseEntity<>(userDTO, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		return userService.delete(id) ? ResponseEntity.ok(id) : ResponseEntity.notFound().build();
	}

}
