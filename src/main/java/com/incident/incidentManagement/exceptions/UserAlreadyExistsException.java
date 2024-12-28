package com.incident.incidentManagement.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String userName) {
        super("User with username '" + userName + "' already exists.");
    }
}
