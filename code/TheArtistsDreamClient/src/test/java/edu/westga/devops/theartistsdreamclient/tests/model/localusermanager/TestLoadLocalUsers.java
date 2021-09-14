package edu.westga.devops.theartistsdreamclient.tests.model.localusermanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

public class TestLoadLocalUsers {
    @Test
    public void TestLoadedLocalUsers() {
        LocalUserManager testUserManager = new LocalUserManager();
        testUserManager.loadLocalUsers();
        assertEquals(5, testUserManager.size());
    }
}
