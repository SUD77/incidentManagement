package com.incident.incidentManagement.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userName) {
        super("User with username '" + userName + "' not found.");
    }
}
