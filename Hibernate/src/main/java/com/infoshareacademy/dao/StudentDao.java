package com.infoshareacademy.dao;

import com.infoshareacademy.model.Student;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Student s) {
        entityManager.persist(s);
        return s.getId();
    }

    public Student update(Student s) {
        return entityManager.merge(s);
    }

    public void delete(Long id) {
        final Student s = entityManager.find(Student.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Student s");

        return query.getResultList();
    }

    public List<Student> findAllBornAfter(LocalDate date) {
        final Query query = entityManager.createNamedQuery("bornAfter");
        query.setParameter("date", date);
        return query.getResultList();
    }

}
