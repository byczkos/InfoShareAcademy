package com.isa.usersengine.servlets;

import com.isa.usersengine.cdi.FileUploadProcessor;
import com.isa.usersengine.cdi.FileUploadProcessorBean;
import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.exceptions.UserImageNotFound;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-user")
@MultipartConfig
public class AddUserServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger LOG = Logger.getLogger(AddUserServlet.class.getName());

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

        Part filePart = req.getPart("image");
        File file = null;
        try {
            file = fileUploadProcessor.uploadImageFile(filePart);
            // musimy wczytac jakiemu uzytkownikowi dopasowac plik
            user.setImageURL("/images/" + file.getName());
        } catch (UserImageNotFound userImageNotFound) {
            LOG.log(Level.SEVERE, userImageNotFound.getMessage());
        }

        usersRepositoryDao.addUser(user);
        resp.sendRedirect("/users-list");

//        printWriter.write("Uzytkownik został dodany!\n\n");
//        printWriter.write("ID: "+ user.getId() + "\n");
//        printWriter.write("Name: "+ user.getName() + "\n");
//        printWriter.write("Login: "+ user.getLogin() + "\n");
//        printWriter.write("Age: "+ user.getAge() + "\n");
    }
}
