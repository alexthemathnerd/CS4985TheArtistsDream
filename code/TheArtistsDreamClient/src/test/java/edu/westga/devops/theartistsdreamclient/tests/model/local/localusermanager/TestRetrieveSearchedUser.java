package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import edu.westga.devops.theartistsdreamclient.model.User;

import java.utils.List;

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
        assertEquals(null, testManager.retrieveSearchedUser("test"));
    }

    @Test
    void testSearchedUserNotFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.add("test1","test1","test1");
        testManager.add("test2","test2","test2");
        testManager.add("test3","test3","test3");
        assertEquals(null, testManager.retrieveSearchedUser("test"));
    }

    @Test
    void testSearchedUserFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.add("test","test","test");
        testManager.add("test1","test1","test1");
        testManager.add("test2","test2","test2");
        assertNotNull(testManager.retrieveSearchedUser("test"));
    }
}
