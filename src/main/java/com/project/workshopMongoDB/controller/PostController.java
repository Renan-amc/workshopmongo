package com.project.workshopMongoDB.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.workshopMongoDB.controller.util.URL;
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
	
	@GetMapping(value = "/posts/titlesearch")
	public List<Post> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return list;
	}

	@GetMapping(value = "/posts/fullsearch")
	public List<Post> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.fullSearch(text, min, max);
		return list;
	}
	
}