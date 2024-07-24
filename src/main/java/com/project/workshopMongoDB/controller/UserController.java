package com.project.workshopMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.workshopMongoDB.data.User;
import com.project.workshopMongoDB.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@PostMapping(path = "/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping(path = "/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable(name = "id") String id) {
		user.setId(id);
		userService.updateUser(user);
		return user;
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUserById(@PathVariable String id) {
		userService.deleteUserById(id);
	}
}