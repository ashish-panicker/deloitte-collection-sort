package com.example.demo.jpa.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.model.Note;
import com.example.demo.jpa.repositories.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	private NoteRepository noteRepo;

	@GetMapping("/notes")
	public List<Note> findAll() {
		return noteRepo.findAll();
	}

	@PostMapping("/notes")
	public Note saveNote(@Valid @RequestBody Note note) {
		return noteRepo.save(note);
	}

	@GetMapping("/notes/{id}")
	public Optional<Note> getNoteById(@PathVariable(value = "id") Long noteId) {
		return noteRepo.findById(noteId);
	}

	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody Note n) {
		Optional<Note> note = noteRepo.findById(id);
		if(note.isPresent()) {
			note.get().setTitle(n.getTitle());
			note.get().setContent(n.getContent());
			n = noteRepo.save(note.get());
		}
		return n;
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Note> deletNote(@PathVariable(value = "id") Long id) {
		Optional<Note> note = noteRepo.findById(id);
		if(note.isPresent()) {
			noteRepo.delete(note.get());
		}
		return ResponseEntity.ok(note.get());
	}
}
