package edu.westga.devops.theartistsdreamserver.tests.model.request;

import edu.westga.devops.theartistsdreamserver.model.Request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * JUnit Test Case for Request Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testTwoParameterConstructor() {
		Request testRequest = new Request("Test", 1);
		assertAll(() -> assertEquals("Test", testRequest.getError()), () -> assertEquals(1, (int) testRequest.getData()));
	}

	@Test
	void testErrorOnlyConstructor() {
		Request testRequest = new Request("test");
		assertAll(() -> assertEquals("test", testRequest.getError()), () -> assertNull(testRequest.getData()));
	}

	@Test
	void testDataOnlyConstructor() {
		Request testRequest = new Request(1);
		assertAll(() -> assertEquals(1, (int) testRequest.getData()), () -> assertNull(testRequest.getError()));
	}

}
