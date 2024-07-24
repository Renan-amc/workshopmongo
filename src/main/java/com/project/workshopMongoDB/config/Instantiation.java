package com.project.workshopMongoDB.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.workshopMongoDB.data.User;
import com.project.workshopMongoDB.data.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "Brown", "address1", "occupation1");
		User alex = new User(null, "Alex", "Green", "address2", "occupation2");
		User bob = new User(null, "Bob", "Grey","address3", "occupation3");
		
		userRepository.save(alex);
		userRepository.save(maria);
		userRepository.save(bob);
	}
	
}
