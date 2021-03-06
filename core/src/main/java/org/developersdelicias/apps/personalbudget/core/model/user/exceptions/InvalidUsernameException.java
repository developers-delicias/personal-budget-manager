package org.developersdelicias.apps.personalbudget.core.model.user.exceptions;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String username) {
        super(String.format("%s is an invalid username.", username));
    }
}
