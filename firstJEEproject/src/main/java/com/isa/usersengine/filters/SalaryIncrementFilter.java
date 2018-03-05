package com.isa.usersengine.filters;

import com.isa.usersengine.servlets.WelcomeUserServlet;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        filterName = "SalaryIncrementFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "minSalary", value = "100")
        }
)

public class SalaryIncrementFilter implements Filter {

    double minSalary =0.0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        minSalary = Double.parseDouble(filterConfig.getInitParameter("minSalary"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String reqSalary = request.getParameter("salary");
        if (reqSalary == null || reqSalary.isEmpty()) {
            reqSalary = "0.0";
        }
        double salary = Double.parseDouble(reqSalary);
        if( salary < 100) {
            salary = minSalary;
        }
        request.setAttribute("salary",salary);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        minSalary = 0.0;
    }
}
