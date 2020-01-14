package com.example.boot.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot.demo.model.User;

@Controller
public class IndexController {

	private static List<User> users = new ArrayList<>();
	
	private static int id = 2;

	static {
		users.add(new User(1, "Ashish", "ashish@gmail.com"));
		users.add(new User(2, "Ishann", "Ishann@gmail.com"));
	}

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name, Model model) {
		model.addAttribute("user", name);
		return "hello";
	}

	@GetMapping("/welcome/{userName}")
	public String Welcome(@PathVariable(name = "userName") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome";
	}

	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		model.addAttribute("sid", id);
		return "users";
	}
	
	@PostMapping("/users")
	public String addUser(User user) {
		users.add(user);
		return "redirect:/users";
	}

}

