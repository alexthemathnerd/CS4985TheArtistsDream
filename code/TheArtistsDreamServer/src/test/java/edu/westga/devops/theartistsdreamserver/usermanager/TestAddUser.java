package edu.westga.devops.theartistsdreamserver.usermanager;
import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;


public class TestAddUser {

    @Test
	void testAddToEmptyManager() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        Object result = 0;
		assertEquals(result, testManager.addUser(user).getData());
	}

	@Test
	void testAddAlreadyExistingUser() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] user = new Object[]{"test", "test", "test"};
        testManager.addUser(user);
        Object result = -1;
		assertEquals(result, testManager.addUser(user).getData());
	}

	@Test
	void testAddUniqueUser() {
        TheArtistsDreamServer.USERS.clear();
        UserManager testManager = new UserManager();
        Object[] user1 = new Object[]{"test", "test", "test"};
        Object[] user2 = new Object[]{"test1", "test1", "test1"};
        testManager.addUser(user1);
        Object result = 1;
		assertEquals(result, testManager.addUser(user2).getData());
	}

}
