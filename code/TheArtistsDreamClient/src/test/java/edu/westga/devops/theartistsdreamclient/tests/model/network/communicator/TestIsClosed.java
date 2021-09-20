package edu.westga.devops.theartistsdreamclient.tests.model.network.communicator;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * JUnit Test Case for Communicator method isClosed
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestIsClosed {

	@Test
	void testNotClosed() {
		Communicator testCommunicator = new Communicator("tcp://localhost:4444");
		assertFalse(testCommunicator.isClosed());
	}

	@Test
	void testClosed() {
		Communicator testCommunicator = new Communicator("tcp://localhost:4444");
		testCommunicator.close();

		assertTrue(testCommunicator.isClosed());
	}

}
