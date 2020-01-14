package com.example.demo.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.jpa.model.Note;
import com.example.demo.jpa.repositories.NoteRepository;

@Controller
@RequestMapping("/html")
public class ViewController {

	@Autowired
	private NoteRepository repo;

	@GetMapping(value = {  "/index" })
	public String allNotes(Model model) {
		model.addAttribute("notes", repo.findAllByOrderByCreatedAtDesc());
		return "html/index";
	}
	
	@GetMapping(value = { "/notes" })
	public String newNote(Model model) {
		model.addAttribute("note", new Note());
		return "html/create";
	}
	
	@PostMapping(value = { "/notes" })
	public String createNote(Note note) {
		repo.save(note);
		return "redirect:/home/index";
	}

}
