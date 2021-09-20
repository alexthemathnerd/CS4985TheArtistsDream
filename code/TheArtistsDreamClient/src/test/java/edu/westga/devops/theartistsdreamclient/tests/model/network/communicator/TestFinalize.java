package edu.westga.devops.theartistsdreamclient.tests.model.network.communicator;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for Communicator method finalize
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestFinalize {

	@Test
	void testFinalize() {
		Communicator testCommunicator = new Communicator("tcp://localhost:4444");
		testCommunicator.finalize();
		assertTrue(testCommunicator.isClosed());
	}

}
