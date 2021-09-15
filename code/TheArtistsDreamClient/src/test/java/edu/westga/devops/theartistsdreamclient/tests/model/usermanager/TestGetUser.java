package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the methods get user in the local user manager
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestGetUser {
    @Test
    public void testNullUsername() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser(null,"password");
        });
    }

    @Test
    public void testNullPassword() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser("username",null);
        });
    }

    @Test
    public void testEmptyUsername() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser("","password");
        });
    }

    @Test
    public void testEmptyPassword() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser("username","");
        });
    }

    @Test
    public void testNegativeId() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser(-1);
        });
    }

    @Test
    public void testGetUserById() {
            UserManager testUserManager = new UserManager();
            User testUser = new User(0, "test@gmail.com","test","test1");
            testUserManager.addUser(testUser);
             assertEquals(testUser, testUserManager.getUser(0));         
    }

    @Test
    public void testGetUserByUsernameAndPassword() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertEquals(testUser, testUserManager.getUser(testUser.getUsername(), testUser.getPassword()));     
    }

    @Test
    public void testGetUserByUsernameAndPasswordNotFound() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com","test","test1");
        assertEquals(null, testUserManager.getUser(testUser.getUsername(), testUser.getPassword()));     
    }

    @Test
    public void testGetUserByIdNotFound() {
        UserManager testUserManager = new UserManager();
        assertEquals(null, testUserManager.getUser(0));     
    }
}
