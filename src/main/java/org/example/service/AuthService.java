package org.example.service;

import org.example.exception.WrongDataFromClientException;
import org.example.model.Driver;

public interface AuthService {
    Driver login(String login, String password) throws WrongDataFromClientException;
}
