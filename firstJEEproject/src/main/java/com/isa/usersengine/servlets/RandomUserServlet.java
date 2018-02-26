package com.isa.usersengine.servlets;

import com.isa.usersengine.cdi.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("random")
public class RandomUserServlet extends HttpServlet {

    @Inject
    RandomUserCDIApplicationDao AppInject;

    @Inject
    RandomUserCDISessionDao SessInject;

    @Inject
    RandomUserCDIRequestDao ReqInject;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        printWriter.write("Application: "+AppInject.getRandomUser().getName()+"\n");
        printWriter.write("Session: "+SessInject.getRandomUser().getName()+"\n");
        printWriter.write("Request: "+ReqInject.getRandomUser().getName()+"\n");

    }
}
