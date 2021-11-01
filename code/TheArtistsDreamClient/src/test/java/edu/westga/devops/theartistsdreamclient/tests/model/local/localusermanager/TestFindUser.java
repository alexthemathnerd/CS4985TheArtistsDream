package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Case for LocalUserManager method findUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestFindUser {


    @Test
    void testNullUsername() {
        LocalUserManager testManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> testManager.findUser(null, "test"));
    }

    @Test
    void testNullPassword() {
        LocalUserManager testManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> testManager.findUser("test", null));
    }

    @Test
    void testEmptyUsername() {
        LocalUserManager testManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> testManager.findUser("", "test"));
    }

    @Test
    void testEmptyPassword() {
        LocalUserManager testManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> testManager.findUser("test", ""));
    }


    @Test
    void testUserFound() {
        LocalUserManager testManager = new LocalUserManager();
        testManager.addUser("test", "test", "test");
        assertNotNull(testManager.findUser("test", "test"));
    }

    @Test
    void testUserNotFound() {
        LocalUserManager testManager = new LocalUserManager();
        assertNull(testManager.findUser("test", "test"));
    }

}
