package edu.westga.devops.theartistsdreamclient.tests.model.network.communicator;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for Communicator Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

    @Test
    void testInvalidAddress() {
        Communicator testCommunicator = new Communicator("");
        assertTrue(testCommunicator.isClosed());
    }

    @Test
    void testValidAddress() {
        Communicator testCommunicator = new Communicator("tcp://localhost:4444");
        assertFalse(testCommunicator.isClosed());
    }

}
