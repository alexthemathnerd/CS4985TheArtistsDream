package edu.westga.devops.theartistsdreamclient.tests.viewmodel.loginviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LoginViewModel Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

    @Test
    void testPropertyCreations() {
        LoginViewModel testViewModel = new LoginViewModel();
        assertAll(() -> assertEquals("", testViewModel.errorProperty().get()), () -> assertEquals("", testViewModel.usernameProperty().get()), () -> assertEquals("", testViewModel.passwordProperty().get()), () -> assertEquals("", testViewModel.confirmPasswordProperty().get()), () -> assertEquals("", testViewModel.emailProperty().get()));
    }

}
