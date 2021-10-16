package edu.westga.devops.theartistsdreamclient.tests.viewmodel.loginviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * JUnit Test Case for LoginViewModel Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testPropertyCreations() {
		LoginViewModel testViewModel = new LoginViewModel();
		assertAll(() -> assertEquals("", testViewModel.errorLabelStringProperty().get()), () -> assertEquals("", testViewModel.usernameStringProperty().get()), () -> assertEquals("", testViewModel.passwordStringProperty().get()), () -> assertEquals("", testViewModel.confirmPasswordStringProperty().get()), () -> assertEquals("", testViewModel.emailStringProperty().get()));
	}

}
