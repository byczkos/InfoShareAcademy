package com.infoshareacademy.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

@Entity
@Table(name = "STUDENTS")
@NamedQuery(name = "bornAfter",
        query = "SELECT s FROM Student s WHERE s.dateOfBirth >= :date ORDER BY s.dateOfBirth DESC")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "dateOfBirth")
    @NotNull
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "computer_id", unique = true)
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENTS_TO_COURSES",
        joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "id"))
    private Set<Course> courses;


    public Student() {

    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Student(String name, String surname, LocalDate dateOfBirth, Computer computer, Address address, Set<Course> courses) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.computer = computer;
        this.address = address;
        this.courses = courses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", computer=").append(computer);
        sb.append(", address=").append(address);
        sb.append(", courses=").append(courses.stream().map(Course::getName).collect(joining(", ")));
        sb.append('}');
        return sb.toString();
    }
}
