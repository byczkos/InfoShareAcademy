package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        PrintWriter printWriter = resp.getWriter();

        String id = req.getParameter("id");
        if(id == null || id.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String name = req.getParameter("name");
        if(name == null || name.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String login = req.getParameter("login");
        if(login == null || login.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String age = req.getParameter("age");
        if(age == null || age.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String password = req.getParameter("password");
        if(password == null || password.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        int intAge = Integer.parseInt(age);
        int intId = Integer.parseInt(id);

        user.setAge(intAge);
        user.setId(intId);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        usersRepositoryDao.addUser(user);
        resp.sendRedirect("/users-list");

//        printWriter.write("Uzytkownik został dodany!\n\n");
//        printWriter.write("ID: "+ user.getId() + "\n");
//        printWriter.write("Name: "+ user.getName() + "\n");
//        printWriter.write("Login: "+ user.getLogin() + "\n");
//        printWriter.write("Age: "+ user.getAge() + "\n");
    }
}
