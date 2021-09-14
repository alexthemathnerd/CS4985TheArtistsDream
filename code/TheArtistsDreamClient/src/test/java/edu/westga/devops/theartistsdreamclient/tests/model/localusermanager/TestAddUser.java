package edu.westga.devops.theartistsdreamclient.tests.model.localusermanager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

import org.junit.jupiter.api.Test;

/**
 * Test class for the add user method in the local user manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestAddUser {
    @Test
    public void testNullUser() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.addUser(null);
        });
    }

    @Test
    public void testAddDuplicateUser() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.addUser(testUser);
        });
    }

    @Test
    public void testAddValidUser() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertAll(() -> {
            assertEquals(1, testUserManager.size());
            assertEquals(true, testUserManager.checkForUser(testUser.getUserId()));
        });
    }
}