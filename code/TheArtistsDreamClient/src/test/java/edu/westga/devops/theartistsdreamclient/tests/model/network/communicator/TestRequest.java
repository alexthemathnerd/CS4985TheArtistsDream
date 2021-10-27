package edu.westga.devops.theartistsdreamclient.tests.model.network.communicator;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for Communicator methods request
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestRequest {

    @Test
    void testClosedTwoParameter() {
        Communicator testCommunicator = new Communicator("tcp://localhost:4444");
        testCommunicator.close();
        assertThrows(IllegalStateException.class, () -> testCommunicator.request(null, null));
    }

}
