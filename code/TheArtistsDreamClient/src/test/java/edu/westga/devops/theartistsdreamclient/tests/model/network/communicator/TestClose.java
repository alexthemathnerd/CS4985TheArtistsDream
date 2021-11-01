package edu.westga.devops.theartistsdreamclient.tests.model.network.communicator;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for Communicator Method close
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestClose {

    @Test
    void testClose() {
        Communicator testCommunicator = new Communicator("tcp://localhost:4444");
        testCommunicator.close();
        assertTrue(testCommunicator.isClosed());
    }

}
