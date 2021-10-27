package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for UserManager Method retrieveSearchedUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestRetrieveSearchedUser {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.retrieveSearchedUser(new Object[] {1}).getError());
	}

	@Test
	void testValidNotFound() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		assertNull(UserManager.retrieveSearchedUser(new Object[] {"test7"}).getData());
	}

	@Test
	void testValidFound() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test456", "test2@westga.edu"});
		assertNotNull(UserManager.retrieveSearchedUser(new Object[] {"test2"}).getData());
	}

}
