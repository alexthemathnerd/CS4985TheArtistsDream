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

		testViewModel.usernameProperty().set("student");
		testViewModel.passwordProperty().set("student123");
		testViewModel.emailProperty().set("student@my.westga.edu");

		testViewModel.addUser();

		assertNotNull(testViewModel.getUser());
	}

	@Test
	void testGetUserThatDoesNotExist() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.usernameProperty().set("student");
		testViewModel.passwordProperty().set("student123");
		testViewModel.emailProperty().set("student@my.westga.edu");

		testViewModel.addUser();

		testViewModel.usernameProperty().set("test");
		testViewModel.passwordProperty().set("test123");

		assertNull(testViewModel.getUser());
	}

}
