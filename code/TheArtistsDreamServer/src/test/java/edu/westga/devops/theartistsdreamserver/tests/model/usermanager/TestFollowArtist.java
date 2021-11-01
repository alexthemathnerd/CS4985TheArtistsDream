package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for UserManager Method followArtist
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestFollowArtist {

	@BeforeEach
	void clearUsers() {
		TheArtistsDreamServer.USERS.clear();
	}

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.followArtist(new Object[] {1, 1, 1, 1}).getError());
	}

	@Test
	void testOutOfBounds() {
		assertEquals(UI.ErrorMessages.USER_NOT_FOUND, UserManager.followArtist(new Object[] {30.0, 30.0, new User(1, "test@my.westga.edu", "test", "test123", new byte[0]), new User(1, "test@my.westga.edu", "test", "test123", new byte[0])}).getError());
	}

	@Test
	void testValidTrue() {
		UserManager.addUser(new Object[] {"test", "test123", "test@my.westga.edu"});
                UserManager.addUser(new Object[] {"test2", "test456", "test2@my.westga.edu"});
                User testUser = (User) UserManager.getUser(new Object[] {4.0}).getData();
                User testUser2 = (User) UserManager.getUser(new Object[] {5.0}).getData();
		assertTrue((boolean) UserManager.followArtist(new Object[] {0.0, 1.0, testUser, testUser2}).getData());
	}

	@Test
	void testValidFalse() {
		UserManager.addUser(new Object[] {"test", "test123", "test@my.westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test456", "test2@my.westga.edu"});
		User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
		testUser.addFollowing(1);
		User testUser2 = (User) UserManager.getUser(new Object[] {1.0}).getData();
		assertFalse((boolean) UserManager.followArtist(new Object[] {0.0, 1.0, testUser, testUser2}).getData());
	}
}
