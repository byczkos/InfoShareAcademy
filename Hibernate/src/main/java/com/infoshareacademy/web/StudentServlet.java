package com.infoshareacademy.web;

import com.infoshareacademy.dao.AddressDao;
import com.infoshareacademy.dao.StudentDao;
import com.infoshareacademy.dao.ComputerDao;
import com.infoshareacademy.model.Address;
import com.infoshareacademy.model.Computer;
import com.infoshareacademy.model.Student;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(StudentServlet.class);

    @Inject
    private StudentDao studentDao;

    @Inject
    private ComputerDao computerDao;

    @Inject
    private AddressDao addressDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Test data
        // Students

        Address address1 = new Address("Jagielonska","Gdańsk");
        Address address2 = new Address("Grunwaldzka","Warszawa");

        Computer computer1 = new Computer("Mac Book", "MacOS");
        Computer computer2 = new Computer("Dell Inspiron", "Ubuntu");

        computerDao.save(computer1);
        computerDao.save(computer2);

        addressDao.save(address1);
        addressDao.save(address2);

        studentDao.save(new Student("Michal","Michałowski", LocalDate.parse("1991-05-08"), computer1, address1));
        studentDao.save(new Student("Marek", "Markowski", LocalDate.parse("1990-05-03"), computer2, address2));


        LOG.info("System time zone is: {}", ZoneId.systemDefault());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        final String action = req.getParameter("action");
        LOG.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("findAll")) {
            findAll(req, resp);
        } else if (action.equals("add")) {
            addStudent(req, resp);
        } else if (action.equals("delete")) {
            deleteStudent(req, resp);
        } else if (action.equals("update")) {
            updateStudent(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        LOG.info("Updating Student with id = {}", id);

        final Student existingStudent = studentDao.findById(id);
        if (existingStudent == null) {
            LOG.info("No Student found for id = {}, nothing to be updated", id);
        } else {
            existingStudent.setName(req.getParameter("name"));
            existingStudent.setSurname(req.getParameter("surname"));
            existingStudent.setDateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")));

            final Long computerId = Long.parseLong(req.getParameter("computerId"));
            final Computer computer = computerDao.findById(computerId);
            LOG.info("Found Computer with id {}: {}", computerId, computer);
            existingStudent.setComputer(computer);

            studentDao.update(existingStudent);
            LOG.info("Student object updated: {}", existingStudent);
        }

        // Return all persisted objects
        findAll(req, resp);
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        final Student p = new Student();
        p.setName(req.getParameter("name"));
        p.setSurname(req.getParameter("surname"));
        p.setDateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")));

        final Long computerId = Long.parseLong(req.getParameter("computerId"));
        final Computer computer = computerDao.findById(computerId);
        LOG.info("Found Computer with id {}: {}", computerId, computer);
        p.setComputer(computer);

        studentDao.save(p);
        LOG.info("Saved a new Student object: {}", p);

        // Return all persisted objects
        findAll(req, resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        LOG.info("Removing Student with id = {}", id);

        studentDao.delete(id);

        // Return all persisted objects
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Student> result = studentDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (Student p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }
}

