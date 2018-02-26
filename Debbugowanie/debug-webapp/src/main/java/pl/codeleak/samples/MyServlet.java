package pl.codeleak.samples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyServlet", urlPatterns = "/test")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String html = "<html>\n" +
            "<body>\n" +
            "<h2>MyServlet</h2>\n" +
            "</body>\n" +
            "</html>\n";

        resp.getWriter().write(html);
    }
}
