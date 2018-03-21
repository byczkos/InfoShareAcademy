package com.infoshareacademy.springdemo.bean;

import com.infoshareacademy.springdemo.dao.NoteRepository;
import com.infoshareacademy.springdemo.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class InitializeBean {

    @Autowired
    private NoteRepository noteRepository;

    @PostConstruct
    public void onStartup() {
        noteRepository.save(new Note("first dateTime", LocalDateTime.now()));
        noteRepository.save(new Note("second dateTime", LocalDateTime.now()));
        noteRepository.save(new Note("third dateTime", LocalDateTime.now()));

    }
}
