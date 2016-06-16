package org.developersdelicias.apps.personalbudget.core.model.user;

import java.util.regex.Pattern;

public class UsernameValidator {
    public boolean validate(String username) {
        int length = username.length();
        boolean startsWithALowercase = Pattern.compile("^[a-z]+.*").matcher(username).matches();
        return startsWithALowercase && length >= 6 && length <= 15;
    }
}
