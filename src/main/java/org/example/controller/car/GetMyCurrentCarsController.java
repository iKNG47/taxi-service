package org.example.controller.car;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.lib.Injector;
import org.example.model.Car;
import org.example.service.CarService;

public class GetMyCurrentCarsController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org");
    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long driverId = (Long) request.getSession().getAttribute("id");
        List<Car> allCars = carService.getAllByDriver(driverId);
        request.setAttribute("cars", allCars);
        request.setAttribute("delete_driver_car", "DELETE");
        request.getRequestDispatcher("/WEB-INF/views/cars/allMyCars.jsp")
                .forward(request, response);
    }
}
