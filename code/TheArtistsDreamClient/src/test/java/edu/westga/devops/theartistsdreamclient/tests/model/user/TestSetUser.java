package edu.westga.devops.theartistsdreamclient.tests.model.user;

import edu.westga.devops.theartistsdreamclient.model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * JUnit Test Case for User Method setUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSetUser {

	@Test
	void setToNewUser() {
		User.setUser(new User(1, "test", "test", "test", new byte[0]));
		assertAll(() -> assertEquals(1, User.getUser().getUserId()), () -> assertEquals("test", User.getUser().getEmail()), () -> assertEquals("test", User.getUser().getUsername()), () -> assertEquals("test", User.getUser().getPassword()));
	}

	@Test
	void setToNull() {
		User.setUser(null);
		assertNull(User.getUser());
	}

}
