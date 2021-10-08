package edu.westga.devops.theartistsdreamserver.usermanager;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestGetUser {
    @Test
    void TestInvalidArgument() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{""};
		assertNull(testManager.getUser(param).getData());
    }

    @Test
    void testGetUserOnEmptyManager() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{0};
		assertNull(testManager.getUser(param).getData());
	}

    @Test
    void testGetUserOnManagerWithOneUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        testManager.addUser(user);
        Object[] param = new Object[]{0};
		assertNull(testManager.getUser(param).getData());
	}

    @Test
    void testGetUserOnManagerWithMultipleUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        Object[] user1 = new Object[]{"test1", "test1", "test1"};
        Object[] user2 = new Object[]{"test2", "test2", "test2"};
        testManager.addUser(user);
        testManager.addUser(user1);
        testManager.addUser(user2);
        Object[] param = new Object[]{1};
		assertNull(testManager.getUser(param).getData());
	}
}
