package edu.westga.devops.theartistsdreamclient.tests.model.localusermanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;
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
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser(null,"password");
        });
    }

    @Test
    public void testNullPassword() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser("username",null);
        });
    }

    @Test
    public void testEmptyUsername() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser("","password");
        });
    }

    @Test
    public void testEmptyPassword() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser("username","");
        });
    }

    @Test
    public void testNegativeId() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.getUser(-1);
        });
    }

    @Test
    public void testGetUserById() {
            LocalUserManager testUserManager = new LocalUserManager();
            LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
            testUserManager.addUser(testUser);
             assertEquals(testUser, testUserManager.getUser(0));         
    }

    @Test
    public void testGetUserByUsernameAndPassword() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertEquals(testUser, testUserManager.getUser(testUser.getUsername(), testUser.getPassword()));     
    }

    @Test
    public void testGetUserByUsernameAndPasswordNotFound() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
        assertEquals(null, testUserManager.getUser(testUser.getUsername(), testUser.getPassword()));     
    }

    @Test
    public void testGetUserByIdNotFound() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertEquals(null, testUserManager.getUser(0));     
    }
}
