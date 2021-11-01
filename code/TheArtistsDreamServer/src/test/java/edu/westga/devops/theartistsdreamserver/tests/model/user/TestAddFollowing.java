package edu.westga.devops.theartistsdreamserver.tests.model.user;

import edu.westga.devops.theartistsdreamserver.model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for User Method addFollowing
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestAddFollowing {

	@Test
	void testAdd() {
		User testUser = new User(1, "test@my.westga.edu", "test", "test123", new byte[0]);
		assertTrue(testUser.addFollowing(2));
	}

}
