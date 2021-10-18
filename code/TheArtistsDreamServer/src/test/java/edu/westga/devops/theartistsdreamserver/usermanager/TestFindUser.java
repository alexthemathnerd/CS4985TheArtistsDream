package edu.westga.devops.theartistsdreamserver.usermanager;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Junit test class for the Find user method in the User Manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestFindUser {
    @Test
    void TestInvalidArgument() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{null, null};
		assertNull(UserManager.findUser(param).getData());
    }

    @Test
    void testFindUserOnEmptyManager() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{"test","test"};
		assertNull(UserManager.findUser(param).getData());
	}

    @Test
    void testFindUserOnManagerWithOneUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        UserManager.addUser(user);
        Object[] param = new Object[]{"test", "test"};
		assertNotNull(UserManager.findUser(param).getData());
	}

    @Test
    void testFindUserOnManagerWithMultipleUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        Object[] user1 = new Object[]{"test1", "test1", "test1"};
        Object[] user2 = new Object[]{"test2", "test2", "test2"};
        UserManager.addUser(user);
        UserManager.addUser(user1);
        UserManager.addUser(user2);
        Object[] param = new Object[]{"test1", "test1"};
		assertNotNull(UserManager.findUser(param).getData());
	}
}
