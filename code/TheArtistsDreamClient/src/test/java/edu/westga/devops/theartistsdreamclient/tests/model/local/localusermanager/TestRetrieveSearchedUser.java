package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import edu.westga.devops.theartistsdreamclient.model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * JUnit test case for LocalUserManager method retrieveSearchedUser
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestRetrieveSearchedUser {
    @Test
    void testNullUsername() {
        LocalUserManager testManager = new LocalUserManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.retrieveSearchedUser(null));
    }

    @Test
    void testEmptyUsername() {
        LocalUserManager testManager = new LocalUserManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.retrieveSearchedUser(""));
    }

    @Test
    void testRetieveSearchedUserEmptyManager() {
        LocalUserManager testManager = new LocalUserManager();
        assertNull(testManager.retrieveSearchedUser("test"));
    }

    @Test
    void testSearchedUserNotFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test1","test1","test1");
        testManager.addUser("test2","test2","test2");
        testManager.addUser("test3","test3","test3");
        assertNull(testManager.retrieveSearchedUser("test"));
    }

    @Test
    void testSearchedUserFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test","test","test");
        testManager.addUser("test1","test1","test1");
        testManager.addUser("test2","test2","test2");
        assertNotNull(testManager.retrieveSearchedUser("test"));
    }
}
