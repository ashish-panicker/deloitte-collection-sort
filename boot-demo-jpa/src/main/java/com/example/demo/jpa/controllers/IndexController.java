package com.example.demo.jpa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "Note Jpa Index action.";
	}
}
