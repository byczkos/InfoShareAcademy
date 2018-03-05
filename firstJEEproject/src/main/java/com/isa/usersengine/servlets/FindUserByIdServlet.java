package com.isa.usersengine.servlets;

import com.isa.usersengine.cdi.MaxPulseBean;
import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.Gender;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Inject
    MaxPulseBean maxPulseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        if (ids == null || ids.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        //UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean();
        User user = usersRepositoryDao.getUserById(id);

        PrintWriter printWriter = resp.getWriter();
        if (user == null) {
            printWriter.write("User not found");
            return;
        }

        printWriter.write("ID: " + user.getId() + "\n");
        printWriter.write("Name: " + user.getName() + "\n");
        printWriter.write("Login: " + user.getLogin() + "\n");
        printWriter.write("Age: " + user.getAge() + "\n");

        if (user.getGender() == Gender.MAN) {
            printWriter.write("Pulse: " + maxPulseBean.maxMenPulse(user.getAge()));
        } else {
            printWriter.write("Pulse: " + maxPulseBean.maxWomenPulse(user.getAge()));
        }

    }
}
