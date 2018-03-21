package com.infoshareacademy.springdemo.controller;

import com.infoshareacademy.springdemo.dao.NoteRepository;
import com.infoshareacademy.springdemo.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable(value ="id") Long id) {
        noteRepository.deleteById(id);
    }
}
