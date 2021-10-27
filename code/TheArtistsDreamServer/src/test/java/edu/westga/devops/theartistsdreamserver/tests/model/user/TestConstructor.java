package edu.westga.devops.theartistsdreamserver.tests.model.user;

import edu.westga.devops.theartistsdreamserver.model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for User Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testConstructor() {
		User testUser = new User(1, "test@my.westga.edu", "test", "test123", new byte[0]);
		assertAll(() -> assertEquals(1, testUser.getUserId()), () -> assertEquals("test@my.westga.edu", testUser.getEmail()), () -> assertEquals("test", testUser.getUsername()), () -> assertEquals("test123", testUser.getPassword()), () -> assertNotNull(testUser.getProfilePic()), () -> assertNotNull(testUser.getMessages()), () -> assertNotNull(testUser.getFollowerIds()), () -> assertNotNull(testUser.getFollowingIds()));
	}

}
