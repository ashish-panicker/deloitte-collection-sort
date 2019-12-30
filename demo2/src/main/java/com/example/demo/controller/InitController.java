package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Welcome to Spring Boot Application!";
	}

	@RequestMapping(value = "/about")
	public String about() {
		return "This is a sample Spring Boot application";
	}

	@GetMapping("/hello/{id}/{name}")
	// localhost:5000/hello/1/ashish
	public String hello(@PathVariable int id, @PathVariable String name) {
		return "Welcome to Spring Boot " + name + ". Your Id is: " + id;
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return Arrays.asList(
			new Course(1, "Spring Boot"),
			new Course(2, "Java EE"),
			new Course(3, "HTML"),
			new Course(4, "Bootstrap")
		);
	}
}
