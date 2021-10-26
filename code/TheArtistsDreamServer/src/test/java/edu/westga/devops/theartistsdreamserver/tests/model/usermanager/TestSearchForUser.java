package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for UserManager Method searchForUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSearchForUser {
	
	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, UserManager.searchForUser(new Object[] {1}).getError());
	}

	@Test
	void testValidOneMatches() {
		UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test123", "test2@westga.edu"});
		UserManager.addUser(new Object[] {"test3", "test123", "test3@westga.edu"});
		assertEquals(1, ((List<User>) UserManager.searchForUser(new Object[] {"test1"}).getData()).size());
	}

	@Test
	void testValidAllMatch() {
		TheArtistsDreamServer.USERS.clear();
		UserManager.addUser(new Object[] {"test1", "test123", "test1@westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test123", "test2@westga.edu"});
		UserManager.addUser(new Object[] {"test3", "test123", "test3@westga.edu"});
		assertEquals(3, ((List<User>) UserManager.searchForUser(new Object[] {"test"}).getData()).size());
	}

	@Test
	void testValidNoneMatch() {
                UserManager.addUser(new Object[] {"test1", "test123", "test@westga.edu"});
                UserManager.addUser(new Object[] {"test2", "test123", "test@westga.edu"});
                UserManager.addUser(new Object[] {"test3", "test123", "test@westga.edu"});
                assertEquals(0, ((List<User>) UserManager.searchForUser(new Object[] {"test4"}).getData()).size());
	}

}
