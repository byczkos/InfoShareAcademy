package com.infoshareacademy.springdemo.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

import com.infoshareacademy.springdemo.SpringDemoApplication;
import com.infoshareacademy.springdemo.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDemoApplication.class)
public class NoteControllerTest {
    @Autowired
    private NoteController noteController;

            @Test
     public void shouldCreateNewTest() {
                // given
                Note newNote = new Note("TEST 123", LocalDateTime.now());
                // when
                Note savedNote = noteController.createNote(newNote);
                // then
                assertNotNull(savedNote.getId());
            }
}