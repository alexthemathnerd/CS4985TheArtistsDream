package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * JUnit Test Case for UserManager Method isFollowing
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestIsFollowing {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.isFollowing(new Object[] {1, 1}).getError());
	}

	@Test
	void testOutOfBounds() {
		assertEquals(UI.ErrorMessages.USER_NOT_FOUND, UserManager.isFollowing(new Object[] {100.0, 100.0}).getError());
	}

	@Test
	void testValidTrue() {
		UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test123", "test2@westga.edu"});
		User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
		User testUser2 = (User) UserManager.getUser(new Object[] {1.0}).getData();
		testUser.addFollowing(1);
		assertTrue((boolean) UserManager.isFollowing(new Object[] {0.0, 1.0}).getData());
	}

	@Test
	void testValidFalse() {
                UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
                UserManager.addUser(new Object[] {"test2", "test123", "test2@westga.edu"});
                User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
                User testUser2 = (User) UserManager.getUser(new Object[] {1.0}).getData();
                assertFalse((boolean) UserManager.isFollowing(new Object[] {0.0, 1.0}).getData());
	}

}
