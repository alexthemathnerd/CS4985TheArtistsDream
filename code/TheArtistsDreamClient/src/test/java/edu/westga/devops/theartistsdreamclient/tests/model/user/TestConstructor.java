package edu.westga.devops.theartistsdreamclient.tests.model.user;

import edu.westga.devops.theartistsdreamclient.model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * JUnit Test Case for User Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

	@Test
	void testNegativeUserId() {
		assertThrows(IllegalArgumentException.class, () -> new User(-1, "test", "test", "test", new byte[0]));
	}

	@Test
	void testNullEmail() {
		assertThrows(IllegalArgumentException.class, () -> new User(1, null, "test", "test", new byte[0]));
	}

	@Test
	void testEmptyEmail() {
		assertThrows(IllegalArgumentException.class, () -> new User(1, "", "test", "test", new byte[0]));
	}

	@Test
	void testNullUsername() {
		assertThrows(IllegalArgumentException.class, () -> new User(1, "test", null, "test", new byte[0]));
	}

	@Test
	void testEmptyUsername() {
		assertThrows(IllegalArgumentException.class, () -> new User(1, "test", "", "test", new byte[0]));
	}

	@Test
	void testNullPassword() {
		assertThrows(IllegalArgumentException.class, () -> new User(1, "test", "test", null, new byte[0]));
	}

	@Test
	void testEmptyPassword() {
		assertThrows(IllegalArgumentException.class, () -> new User(1, "test", "test", "", new byte[0]));
	}

	@Test
	void testValidParameters() {
		User testUser = new User(1, "test email", "test username", "test password", new byte[0]);
		assertAll(() -> assertEquals(1, testUser.getUserId()), () -> assertEquals("test email", testUser.getEmail()), () -> assertEquals("test username", testUser.getUsername()), () -> assertEquals("test password", testUser.getPassword()), () -> assertEquals(0, testUser.getFollowerIds().size()), () -> assertEquals(0, testUser.getFollowingIds().size()));
		
	}
}
