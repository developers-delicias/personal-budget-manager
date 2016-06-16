package org.developersdelicias.apps.personalbudget.core.model.user;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UsernameValidatorShould {

    private UsernameValidator validator = new UsernameValidator();

    @Test
    @Parameters(source = UsernameTestDataProvider.class, method = "validUsernames")
    public void inform_when_a_username_is_valid(String username) throws Exception {
        assertThat(validator.validate(username), is(true));
    }

    @Test
    @Parameters(source = UsernameTestDataProvider.class, method = "invalidUsernames")
    public void inform_when_a_username_is_invalid(String username) throws Exception {
        assertThat(validator.validate(username), is(false));

    }
}
