package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

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
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.addUser(null);
        });
    }

    @Test
    public void testAddDuplicateUser() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.addUser(testUser);
        });
    }

    @Test
    public void testAddValidUser() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertAll(() -> {
            assertEquals(1, testUserManager.size());
            assertEquals(true, testUserManager.checkForUser(testUser.getUserId()));
        });
    }
}