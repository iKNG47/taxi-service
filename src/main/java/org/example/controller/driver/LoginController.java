package org.example.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.example.exception.WrongDataFromClientException;
import org.example.lib.Injector;
import org.example.model.Driver;
import org.example.service.AuthService;

public class LoginController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org");
    private final AuthService authService = (AuthService) injector.getInstance(AuthService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Driver driver = authService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("id", driver.getId());
            session.setAttribute("name", driver.getName());
            resp.sendRedirect(req.getContextPath() + "/index");

        } catch (WrongDataFromClientException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/drivers/login.jsp").forward(req, resp);
        }
    }
}
