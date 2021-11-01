package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for UserManager Method getFollowerIds
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetFollowerIds {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.getFollowerIds(new Object[] {1}).getError());
	}

	@Test
	void testOutOfBounds() {
		assertEquals(UI.ErrorMessages.USER_NOT_FOUND, UserManager.getFollowerIds(new Object[] {100.0}).getError());
	}

	@Test
	void testGetIds() {
                UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
		assertNotNull(UserManager.getFollowerIds(new Object[] {0.0}).getData());
	}

}
