package com.infoshareacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static java.util.stream.Collectors.joining;


@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<Student> students1;


    public Set<Student> getStudents1() {
        return students1;
    }

    public void setStudents1(Set<Student> students1) {
        this.students1 = students1;
    }

    public Course() {


    }

    public Course(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Course{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", students='").append(
                            students1 != null ? students1.stream().map(Student::getSurname).collect(joining(", "))
                                        : "").append("\'");
        sb.append('}');
        return sb.toString();
    }
}
