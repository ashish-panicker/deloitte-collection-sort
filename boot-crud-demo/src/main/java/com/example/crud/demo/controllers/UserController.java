package com.example.crud.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crud.demo.model.User;
import com.example.crud.demo.repo.UserRepositiry;


@Controller
public class UserController {
	
	@Autowired
	private UserRepositiry userRepo;
	
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("user", new User());
		return "users";
	}
	
	@PostMapping("/users")
	public String addUser(User user) {
		user.setCreationDate(new Date());
		userRepo.save(user);
		return "redirect:/users";
	}

}
