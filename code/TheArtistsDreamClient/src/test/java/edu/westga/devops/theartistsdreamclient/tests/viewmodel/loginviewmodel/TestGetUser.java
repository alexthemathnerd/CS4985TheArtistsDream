package edu.westga.devops.theartistsdreamclient.tests.viewmodel.loginviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for LoginViewModel Method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetUser {

	@Test
	void testGetUserThatExists() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.usernameStringProperty().set("student");
		testViewModel.passwordStringProperty().set("student123");
		testViewModel.emailStringProperty().set("student@my.westga.edu");

		testViewModel.addUser();

		assertNotNull(testViewModel.getUser());
	}

	@Test
	void testGetUserThatDoesNotExist() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.usernameStringProperty().set("student");
		testViewModel.passwordStringProperty().set("student123");
		testViewModel.emailStringProperty().set("student@my.westga.edu");

		testViewModel.addUser();

		testViewModel.usernameStringProperty().set("test");
		testViewModel.passwordStringProperty().set("test123");

		assertNull(testViewModel.getUser());
	}

}
