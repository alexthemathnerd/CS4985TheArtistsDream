package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * JUnit Test Case for UserManager Method unfollowArtist
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestUnfollowUser {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.unfollowArtist(new Object[] {1, 1, 1, 1}).getError());
	}

	@Test
	void testOutOfBounds() {
		assertEquals(UI.ErrorMessages.USER_NOT_FOUND, UserManager.unfollowArtist(new Object[] {100.0, 100.0, new User(1, "test@my.westga.edu", "test", "test123", new byte[0]), new User(1, "test@my.westga.edu", "test", "test123", new byte[0])}).getError());
	}

	@Test
	void testUnfollowFalse() {
		UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test123", "test2@westga.edu"});
		UserManager.addUser(new Object[] {"test3", "test123", "test3@westga.edu"});
		User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
		User testUser2 = (User) UserManager.getUser(new Object[] {1.0}).getData();
		assertFalse((boolean) UserManager.unfollowArtist(new Object[] {0.0, 1.0, testUser, testUser2}).getData());
	}

	@Test
	void testUnfollowTrue() {
		UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test123", "test2@westga.edu"});
		UserManager.addUser(new Object[] {"test3", "test123", "test3@westga.edu"});
		User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
		User testUser2 = (User) UserManager.getUser(new Object[] {1.0}).getData();
		testUser.addFollowing(1);
		testUser2.addFollower(0);
		assertTrue((boolean) UserManager.unfollowArtist(new Object[] {0.0, 1.0, testUser, testUser2}).getData());
	}

}
