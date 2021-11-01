package edu.westga.devops.theartistsdreamserver.tests.model.response;

import edu.westga.devops.theartistsdreamserver.model.Response;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for Response Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testNullCode() {
		assertThrows(IllegalArgumentException.class, () -> new Response(null, new Object[0]));
	}

	@Test
	void testValidParameters() {
		Response testResponse = new Response(UI.ServerCodes.TODO, new Object[0]);
		assertAll(() -> assertEquals(UI.ServerCodes.TODO, testResponse.getCode()), () -> assertNotNull(testResponse.getData()));
	}

}
