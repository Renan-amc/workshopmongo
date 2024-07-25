package com.project.workshopMongoDB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.workshopMongoDB.data.Post;
import com.project.workshopMongoDB.data.PostRepository;
import com.project.workshopMongoDB.service.exception.ObjectNotFoundException;

@Service
public class PostsService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}