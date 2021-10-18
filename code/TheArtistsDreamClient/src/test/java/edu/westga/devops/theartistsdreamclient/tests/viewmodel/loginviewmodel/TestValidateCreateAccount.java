package edu.westga.devops.theartistsdreamclient.tests.viewmodel.loginviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LoginViewModel Method validateCreateAccount
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestValidateCreateAccount {

	@Test
	void testEmailNotMatchingRegex() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.emailProperty().set("student##91754");

		assertAll(() -> assertFalse(testViewModel.validateCreateAccount()), () -> assertEquals(UI.GuiMessages.INVALID_EMAIL, testViewModel.errorProperty().get()));
	}

	@Test
	void testShortPassword() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.emailProperty().set("student@my.westga.edu");
		testViewModel.passwordProperty().set("devops");

		assertAll(() -> assertFalse(testViewModel.validateCreateAccount()), () -> assertEquals(UI.GuiMessages.INVALID_PASSWORD, testViewModel.errorProperty().get()));
	}

	@Test
	void testNonmatchingPasswords() {
		LoginViewModel testViewModel = new LoginViewModel();

		testViewModel.emailProperty().set("student@my.westga.edu");
		testViewModel.passwordProperty().set("student");
		testViewModel.confirmPasswordProperty().set("student1");

		assertAll(() -> assertFalse(testViewModel.validateCreateAccount()), () -> assertEquals(UI.GuiMessages.MISMATCH_PASSWORD, testViewModel.errorProperty().get()));
	}

	@Test
	void testValidProperties() {
		LoginViewModel testViewModel = new LoginViewModel();

                testViewModel.emailProperty().set("student@my.westga.edu");
                testViewModel.passwordProperty().set("student");
		testViewModel.confirmPasswordProperty().set("student");

		assertTrue(testViewModel.validateCreateAccount());
	}

}
