package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalUserManager Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

    @Test
    void testListCreation() {
        LocalUserManager testManager = new LocalUserManager();
        assertEquals(0, testManager.size());
    }

}
