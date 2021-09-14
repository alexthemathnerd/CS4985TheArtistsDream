package edu.westga.devops.theartistsdreamclient.tests.model.localusermanager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

import org.junit.jupiter.api.Test;

public class TestCheckForUser {
    @Test
    public void testUserNotFound() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertEquals(false, testUserManager.checkForUser(0));
    }

    @Test
    public void testUserFound() {
        LocalUserManager testUserManager = new LocalUserManager();
        LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
        testUserManager.addUser(testUser);
        assertEquals(true, testUserManager.checkForUser(0));
    }

    @Test
    public void testNegativeUserId() {
        LocalUserManager testUserManager = new LocalUserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            testUserManager.checkForUser(-1);
        });
    }
}
