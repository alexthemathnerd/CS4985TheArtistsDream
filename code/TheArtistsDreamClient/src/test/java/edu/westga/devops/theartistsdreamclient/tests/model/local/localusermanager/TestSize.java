package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalUserManager method size
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSize {

    @Test
    void testSize() {
        LocalUserManager testManager = new LocalUserManager();
        assertEquals(0, testManager.size());
    }

}
