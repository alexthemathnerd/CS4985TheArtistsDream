package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

/**
 * Test class for the method verify credentials in the local manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestVerifyCredentials {
    @Test
    public void testNullUsername() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials(null, "password");
        });
    }

    @Test
    public void testNullPassword() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials("username", null);
        });
    }

    @Test
    public void testEmptyUsername() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials("", "password");
        });
    }

    @Test
    public void testEmptyPassword() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials("username", "");
        });
    }

    @Test
    public void testCredentialsNotFound() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com", "test", "test1");
        assertEquals(false, testUserManager.verifyCredentials(testUser.getUsername(), testUser.getPassword()));
    }

    @Test
    public void testCredentialsFound() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com", "test", "test1");
        testUserManager.addUser(testUser);
        assertEquals(true, testUserManager.verifyCredentials(testUser.getUsername(), testUser.getPassword()));

    }

}