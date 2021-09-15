package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

import org.junit.jupiter.api.Test;

public class TestCheckForUser {
    @Test
    public void testUserNotFound() {
        UserManager testUserManager = new UserManager();
        assertEquals(false, testUserManager.checkForUser(0));
    }

    @Test
    public void testUserFound() {
        UserManager testUserManager = new UserManager();
        User testUser = new User(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertEquals(true, testUserManager.checkForUser(0));
    }

    @Test
    public void testNegativeUserId() {
        UserManager testUserManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.checkForUser(-1);
        });
    }
}
