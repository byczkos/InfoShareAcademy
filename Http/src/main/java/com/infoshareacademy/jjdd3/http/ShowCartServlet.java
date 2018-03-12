package com.infoshareacademy.jjdd3.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/items")
public class ShowCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        PrintWriter printWriter = resp.getWriter();
        // pobranie z sesji parametru cart i wyswietlenie jego elementow
        List<String> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            printWriter.println("Cart is empty");
        } else {
            printWriter.println("Item in cart : \n");
            for (int i = 0; i < cart.size() ; i++) {
                printWriter.println(cart.get(i));
            }
        }
    }
}
