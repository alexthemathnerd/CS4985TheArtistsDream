package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Junit test class for the method retrieveUser in the User manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestRetrieveUser {
    @Test
    void TestInvalidArgument() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{null};
		assertNull(UserManager.retrieveSearchedUser(param).getData());
    }

    @Test
    void testRetrieveUserOnEmptyManager() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{0};
		assertNull(UserManager.retrieveSearchedUser(param).getData());
	}

    @Test
    void testRetreiveUserOnManagerWithOneUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        UserManager.addUser(user);
        Object[] param = new Object[]{"test"};
		assertNotNull(UserManager.retrieveSearchedUser(param).getData());
	}

    @Test
    void testRetreiveUserOnManagerWithMultipleUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        Object[] user1 = new Object[]{"test1", "test1", "test1"};
        Object[] user2 = new Object[]{"test2", "test2", "test2"};
        UserManager.addUser(user);
        UserManager.addUser(user1);
        UserManager.addUser(user2);
        Object[] param = new Object[]{"test"};
		assertNotNull(UserManager.retrieveSearchedUser(param).getData());
	}
    
}
