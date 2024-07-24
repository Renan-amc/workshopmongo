package com.project.workshopMongoDB.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.project.workshopMongoDB.data.User;
import com.project.workshopMongoDB.data.UserRepository;
import com.project.workshopMongoDB.dto.UserDTO;
import com.project.workshopMongoDB.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAllUser() {
		List<User> user = userRepository.findAll();
		List<UserDTO> listDto = user.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(String id) {
		userRepository.deleteById(id);
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}