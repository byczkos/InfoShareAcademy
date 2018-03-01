package com.infoshareacademy.dao;
import com.infoshareacademy.model.Course;
import com.infoshareacademy.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class CourseDao {
    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Course c) {
        entityManager.persist(c);
        return c.getId();
    }

    public Course update(Course c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final Course c = entityManager.find(Course.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public List<Course> findAll() {
        final Query query = entityManager.createQuery("SELECT c FROM Course c");

        return query.getResultList();
    }

    public Map<String, Integer> getCoursesAttendees() {
        final Query query = entityManager.createNativeQuery("SELECT COUNT(t.student_id), c.name\n"
                + "  FROM COURSES c\n"
                + "  INNER JOIN STUDENTS_TO_COURSES t\n"
                + "      ON c.id=t.course_id\n"
                + "  GROUP BY c.name;");

        final List<Object[]> objects = query.getResultList();

        final Map<String, Integer> result = new HashMap<>();
        for (Object[] row : objects) {
            BigInteger c = (BigInteger) row[0];
            result.put((String) row[1], c.intValue());
        }
        return result;
    }

}
