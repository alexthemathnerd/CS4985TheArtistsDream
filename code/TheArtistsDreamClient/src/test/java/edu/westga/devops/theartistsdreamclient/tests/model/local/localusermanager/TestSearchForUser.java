package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import edu.westga.devops.theartistsdreamclient.model.User;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test case for LocalUserManager method search for Users
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestSearchForUser {
    @Test
    void testNullSearchTerm() {
        LocalUserManager testManager = new LocalUserManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.searchForUsers(null));
    }

    @Test
    void testSearchEmptyManager() {
        LocalUserManager testManager = new LocalUserManager();
        List<User> testSearchedUsers = testManager.searchForUsers("a");
        assertEquals(0, testSearchedUsers.size());
    }

    @Test
    void testSearchNoUsersFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test","test","test");
        testManager.addUser("test1","test1","test1");
        testManager.addUser("test2","test2","test2");
        List<User> testSearchedUsers = testManager.searchForUsers("a");
        assertEquals(0, testSearchedUsers.size());
    }

    @Test
    void testSearchUsersFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test","test","test");
        testManager.addUser("test1","test1","test1");
        testManager.addUser("test2","test2","test2");
        List<User> testSearchedUsers = testManager.searchForUsers("test");
        assertEquals(3, testSearchedUsers.size()); 
    }
}