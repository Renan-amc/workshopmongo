package com.project.workshopMongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.workshopMongoDB.data.Post;
import com.project.workshopMongoDB.service.PostsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostsService postService;

	@GetMapping(value = "/posts/{id}")
	public Post findById(@PathVariable String id) {
		Post obj = postService.findById(id);
		return obj;
	}
	
}