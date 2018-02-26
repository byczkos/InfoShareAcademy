package com.infoshareacademy.jjdd3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void shouldProperlySetFirstAndLastName() {
        Person person = new Person("John", "Doe");

        assertAll("constructor",
                () -> assertEquals("John", person.getFirstName(), "First name:"),
                () -> assertEquals("Doe", person.getLastName(), "Last name:")
        );
    }

    @Test
    void shouldThrowExceptionWhenFirstNameIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Person person = new Person(null, "Doe");
        });

        assertEquals("First name cannot be null!", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
           Person person = new Person("John", null);
        });

        assertEquals("Last name cannot be null!", exception.getMessage());
    }

    @Test
    void shouldReturnPersonFullName() {
        Person person = new Person("John", "Doe");

        assertEquals("John Doe", person.getFullName());
    }
}
