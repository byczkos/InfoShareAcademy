package com.infoshareacademy.locator.web;

import com.infoshareacademy.locator.model.Earthquake;
import com.infoshareacademy.locator.storage.EarthquakesCache;
import com.infoshareacademy.locator.storage.EarthquakesStorage;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/earthquake")
public class EarthquakesServlet extends HttpServlet {

    @Inject
    private EarthquakesCache storage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String year = req.getParameter("year");


//        // Tworzenie cache sesyjnego
        // zrealizowano to rowniez w klasie earthquakesCache stosujac tzw serviceCache
//        //========================================================
//
//        HttpSession session = req.getSession();
//        ServletContext servletContext = getServletContext();
//
//        Object earthquakesCache = session.getAttribute("earthquakesCache");
//
//        if(earthquakesCache == null) {
//            earthquakesCache = new HashMap<String, List<Earthquake>>();
//        }
//
//        Map<String, List<Earthquake>> cachedMap = (Map<String, List<Earthquake>>) earthquakesCache;
//        List<Earthquake> earthquakes;
//
//        if( cachedMap.containsKey(year)) {
//            earthquakes = cachedMap.get(year);
//        } else {
//            earthquakes = storage.getForYear(year);
//            cachedMap.put(year, earthquakes);
//        }
//        servletContext.setAttribute("earthquakesCache", cachedMap);
//
//        //=========================================================

        req.setAttribute("earthquakes", storage.get(year));
        req.setAttribute("year", year);

        req.getRequestDispatcher("earthquakes.jsp").forward(req, resp);
    }
}
