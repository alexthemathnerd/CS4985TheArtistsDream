package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import org.junit.jupiter.api.Test;

import edu.westga.devops.theartistsdreamclient.model.UserManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoadLocalUsers {
    @Test
    public void TestLoadedLocalUsers() {
        UserManager testUserManager = new UserManager();
        testUserManager.loadLocalUsers();
        assertEquals(5, testUserManager.size());
    }
}
