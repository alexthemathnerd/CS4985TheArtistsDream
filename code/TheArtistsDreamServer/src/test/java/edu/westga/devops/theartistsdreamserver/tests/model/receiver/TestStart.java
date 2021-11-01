package edu.westga.devops.theartistsdreamserver.tests.model.receiver;

import edu.westga.devops.theartistsdreamserver.model.Receiver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * JUnit Test Case for Receiver Overriden Method start
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestStart {

	@Test
	void testInvalidAddress() {
		Receiver testReceiver = new Receiver("0.0.0.0");
		assertThrows(IllegalArgumentException.class, () -> testReceiver.start());
	}

}
