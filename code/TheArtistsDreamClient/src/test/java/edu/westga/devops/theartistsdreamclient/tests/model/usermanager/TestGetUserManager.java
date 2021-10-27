package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * JUnit Test Case for User Method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetUserManager {

    @Test
    void testNull() {
        UserManager.setUserManager(null);
        assertNull(UserManager.getUserManager());
    }

    @Test
    void testNotNull() {
        UserManager.setUserManager(new LocalUserManager());
        assertNotNull(UserManager.getUserManager());
    }
}

