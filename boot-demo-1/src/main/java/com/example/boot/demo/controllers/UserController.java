package com.example.boot.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.demo.model.User;

@RestController
public class UserController {
	

	@GetMapping({ "/", "index" })
	public String index() {
		return "Hello World!";
	}

	@GetMapping("/users-rest")
	public List<User> users() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "Ashish", "ashish@gmail.com"));
		users.add(new User(2, "Ishann", "Ishann@gmail.com"));
		return users;
	}
}
