package org.example.service;

import java.util.Optional;
import org.example.exception.WrongDataFromClientException;
import org.example.lib.Inject;
import org.example.lib.Service;
import org.example.model.Driver;

@Service
public class AuthServiceImpl implements AuthService {
    @Inject
    private DriverService driverService;

    @Override
    public Driver login(String login, String password) throws WrongDataFromClientException {
        Optional<Driver> driver = driverService.findByLogin(login);
        if (driver.isEmpty()) {
            throw new WrongDataFromClientException("username or password incorrect");
        }
        if (!driver.get().getPassword().equals(password)) {
            throw new WrongDataFromClientException("username or password incorrect");
        }
        return driver.get();
    }
}
