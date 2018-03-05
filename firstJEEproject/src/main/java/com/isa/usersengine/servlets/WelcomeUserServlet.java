package com.isa.usersengine.servlets;

import com.isa.usersengine.freemarker.TemplateProvider;
import com.sun.net.httpserver.HttpServer;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("welcome-user")
public class WelcomeUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        if(name == null || name.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // data model do freemarkera
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", name);
        dataModel.put("salary", req.getAttribute("salary"));

        Template template = TemplateProvider.createTemplate(getServletContext(), "welcome-user.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }


//        resp.setContentType("text/html;charset=UTF-8");
//        printWriter.write("<DOCTYPE html>");
//        printWriter.write("<html>");
//        printWriter.write("<body>");
//        printWriter.write("Hello :" + name + "!");
//        printWriter.write("<body>");
//        printWriter.write("<html>");
    }
}
