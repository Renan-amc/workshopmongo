package com.project.workshopMongoDB.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.workshopMongoDB.data.Post;
import com.project.workshopMongoDB.data.PostRepository;
import com.project.workshopMongoDB.data.User;
import com.project.workshopMongoDB.data.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria", "Brown", "address1", "occupation1");
		User alex = new User(null, "Alex", "Green", "address2", "occupation2");
		User bob = new User(null, "Bob", "Grey","address3", "occupation3");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.save(alex);
		userRepository.save(maria);
		userRepository.save(bob);
		
		postRepository.save(post1);	
		postRepository.save(post2);	
	}
	
}
