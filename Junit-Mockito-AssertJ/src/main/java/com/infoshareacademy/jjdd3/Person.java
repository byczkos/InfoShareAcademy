package com.infoshareacademy.jjdd3;

public class Person {
    private String firstName;
    private String lastName;
    private String fullName;

    public Person(String firstName, String lastName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null!");
        }

        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null!");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return this.fullName;
    }
}
