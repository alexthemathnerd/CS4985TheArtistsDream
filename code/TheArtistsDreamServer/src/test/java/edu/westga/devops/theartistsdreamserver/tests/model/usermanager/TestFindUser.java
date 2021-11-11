package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for UserManager Method findUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestFindUser {

	@AfterEach
	void destroy() {
		TheArtistsDreamServer.USERS.clear();
	}

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.findUser(new Object[] {1, 1}).getError());
	}

	@Test
	void testValidNotFound() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		assertNull(UserManager.findUser(new Object[] {"test2", "test456"}).getData());
	}

	@Test
	void testValidFound() {
		UserManager.addUser(new Object[] {"test", "test123", "test@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test456", "test2@westga.edu"});
		assertNotNull(UserManager.findUser(new Object[] {"test2", "test456"}).getData());
	}

}
