package com.example.demo.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
	
	List<Note> findByTitle(String title);
	
	List<Note> findAllByOrderByCreatedAtDesc();
}
