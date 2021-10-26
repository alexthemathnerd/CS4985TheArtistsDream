package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for UserManager Method addUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestAddUser {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.addUser(new Object[] {1, 1, 1}).getError());
	}

	@Test
	void testValidFormatNonexistingUser() {
		assertNotNull(UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"}).getData());
	}

	@Test
	void testValidFormatExistingUser() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		assertEquals(UI.ErrorMessages.USER_EXISTS, UserManager.addUser(new Object[] {"test2", "test456", "test@westga.edu"}).getError());
	}

}
