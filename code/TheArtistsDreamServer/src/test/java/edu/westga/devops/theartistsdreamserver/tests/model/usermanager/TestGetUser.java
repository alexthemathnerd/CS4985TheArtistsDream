package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for UserManager Method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetUser {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.getUser(new Object[] {"test"}).getError());
	}

	@Test
	void testValidNonexistingUser() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test456", "test2@westga.edu"});
		assertEquals(UI.ErrorMessages.USER_NOT_FOUND, UserManager.getUser(new Object[] {5.0}).getError());
	}

	@Test
	void testValidExistingUser() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test456", "test2@westga.edu"});
		assertNotNull(UserManager.getUser(new Object[] {1}));
	}

}
