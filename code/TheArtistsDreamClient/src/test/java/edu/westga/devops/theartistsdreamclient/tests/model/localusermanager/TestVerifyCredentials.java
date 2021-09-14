package edu.westga.devops.theartistsdreamclient.tests.model.localusermanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

/**
 * Test class for the method verify credentials in the local manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestVerifyCredentials {
    @Test
    public void testNullUsername() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials(null, "password");
        });
    }

    @Test
    public void testNullPassword() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials("username", null);
        });
    }

    @Test
    public void testEmptyUsername() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials("", "password");
        });
    }

    @Test
    public void testEmptyPassword() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.verifyCredentials("username", "");
        });
    }

    @Test
    public void testCredentialsNotFound() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com", "test", "test1");
        assertEquals(false, testUserManager.verifyCredentials(testUser.getUsername(), testUser.getPassword()));
    }

    @Test
    public void testCredentialsFound() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com", "test", "test1");
        testUserManager.addUser(testUser);
        assertEquals(true, testUserManager.verifyCredentials(testUser.getUsername(), testUser.getPassword()));

    }

}