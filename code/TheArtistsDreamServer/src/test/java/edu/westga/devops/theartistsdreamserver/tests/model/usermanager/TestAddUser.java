package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Junit test class for the Add user method in the User Manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestAddUser {
    @Test
	void testAddToEmptyManager() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        Object result = 0;
		assertEquals(result, UserManager.addUser(user).getData());
	}

	@Test
	void testAddAlreadyExistingUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        UserManager.addUser(user);
        Object result = -1;
		assertEquals(result, UserManager.addUser(user).getData());
	}

	@Test
	void testAddUniqueUser() {
        TheArtistsDreamServer.USERS.clear();
        UserManager testManager = new UserManager();
        Object[] user1 = new Object[]{"test", "test", "test"};
        Object[] user2 = new Object[]{"test1", "test1", "test1"};
        UserManager.addUser(user1);
        Object result = 1;
		assertEquals(result, UserManager.addUser(user2).getData());
	}

}
