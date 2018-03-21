package com.infoshareacademy.springdemo.dao;

import com.infoshareacademy.springdemo.model.Note;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAllByOrderByDateAsc();
    List<Note> findAllByOrderByDateDesc();
}
