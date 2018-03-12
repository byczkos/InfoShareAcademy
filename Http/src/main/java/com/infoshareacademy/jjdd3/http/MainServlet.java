package com.infoshareacademy.jjdd3.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.stream.Collectors.joining;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        //ustawienie naglowku odpowiedzi
        resp.setHeader("InfoShareAcademy"," Java Course");

        // wyswietlanie wszystkich naglowkow, ktore przychodza
        Enumeration<String> header = req.getHeaderNames();
        while (header.hasMoreElements()) {
            String headerName = header.nextElement();
            String headerValue = req.getHeader(headerName);
            printWriter.println(headerName+" : "+ headerValue);
        }


        // wyswietlenie wszystkich parametrow requestu
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()) {
            String paramName = params.nextElement();
            String paramValue = req.getParameter(paramName);
            printWriter.println(paramName+" = "+paramValue);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        PrintWriter printWriter = resp.getWriter();
        params.forEach((key,value) -> {
            printWriter.println(key + " = " + Arrays.asList(value).stream().collect(joining(",")));
        });
    }
}
