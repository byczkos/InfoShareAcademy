package com.infoshareacademy.jjdd3.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/action")
public class ActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // ustawianie statusu odpowiedzi

        if(req.getParameter("cmd").equals("ok")) {
            resp.setStatus(200);
        }else if (req.getParameter("cmd").equals("moved")) {
            resp.setStatus(301);
        }else if (req.getParameter("cmd").equals("auth")) {
            resp.setStatus(403);
        }else if (req.getParameter("cmd").equals("moved")) {
            resp.setStatus(301);
        } else {
            resp.setStatus(400);
        }
    }
}
