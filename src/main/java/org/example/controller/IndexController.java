package org.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.example.lib.Injector;
import org.example.service.AuthService;
import org.example.service.DriverService;

public class IndexController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);
    private final AuthService authService = (AuthService) injector
            .getInstance(AuthService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("driver", session.getAttribute("name"));

        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
