package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalUserManager method addUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestAddUser {

    @Test
    void testAddToEmptyManager() {
        LocalUserManager testManager = new LocalUserManager();
        assertEquals(0, testManager.addUser("test", "test", "test"));
    }

    @Test
    void testAddAlreadyExistingUser() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test", "test", "test");
        assertEquals(-1, testManager.addUser("test", "test", "test"));
    }

    @Test
    void testAddUniqueUser() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test", "test", "test");
        assertEquals(1, testManager.addUser("test2", "test2", "test2"));
    }

}
