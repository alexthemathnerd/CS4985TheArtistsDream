package edu.westga.devops.theartistsdreamclient.tests.model.network.request;

import edu.westga.devops.theartistsdreamclient.model.network.Request;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for Request Constructor 
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

	@Test
	void testNullCode() {
		assertThrows(IllegalArgumentException.class, () -> new Request(null, new Object[0]));
	}

	@Test
	void testValidParameters() {
		Request testRequest = new Request(UI.ServerCodes.TODO, new Object[0]);
		assertAll(() -> assertEquals(UI.ServerCodes.TODO, testRequest.getCode()), () -> assertNotNull(testRequest.getData()));
	}

}
