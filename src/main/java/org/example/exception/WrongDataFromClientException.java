package org.example.exception;

public class WrongDataFromClientException extends Exception {

    public WrongDataFromClientException(String message) {
        super(message);
    }
}
