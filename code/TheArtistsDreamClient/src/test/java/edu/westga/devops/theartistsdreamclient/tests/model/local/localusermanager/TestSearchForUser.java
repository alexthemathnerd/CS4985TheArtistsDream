package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        testManager.addUser("test", "test", "test");
        testManager.addUser("test1", "test1", "test1");
        testManager.addUser("test2", "test2", "test2");
        List<User> testSearchedUsers = testManager.searchForUsers("a");
        assertEquals(0, testSearchedUsers.size());
    }

    @Test
    void testSearchUsersFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test", "test", "test");
        testManager.addUser("test1", "test1", "test1");
        testManager.addUser("test2", "test2", "test2");
        List<User> testSearchedUsers = testManager.searchForUsers("test");
        assertEquals(3, testSearchedUsers.size());
    }
}
