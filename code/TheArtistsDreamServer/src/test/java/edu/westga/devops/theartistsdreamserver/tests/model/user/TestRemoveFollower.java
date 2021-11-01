package edu.westga.devops.theartistsdreamserver.tests.model.user;

import edu.westga.devops.theartistsdreamserver.model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for User Method removeFollower
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestRemoveFollower {

	@Test
	void testAdd() {
		User testUser = new User(1, "test@my.westga.edu", "test", "test123", new byte[0]);
		testUser.addFollower(2);
		assertTrue(testUser.removeFollower(2));
	}

}

