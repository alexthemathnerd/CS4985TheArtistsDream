package edu.westga.devops.theartistsdreamclient.tests.viewmodel.loginviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LoginViewModel Method addUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestAddUser {


	@Test
	void testAddUser() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.usernameProperty().set("student");
		testViewModel.passwordProperty().set("student123");
		testViewModel.emailProperty().set("student@my.westga.edu");

		LocalUserManager testManager = new LocalUserManager();
		UserManager.setUserManager(testManager);

		int previousSize = testManager.size();
		testViewModel.addUser();

		assertEquals(previousSize + 1, testManager.size());
	}

}
