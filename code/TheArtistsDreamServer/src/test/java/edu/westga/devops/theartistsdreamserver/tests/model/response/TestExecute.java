package edu.westga.devops.theartistsdreamserver.tests.model.response;

import edu.westga.devops.theartistsdreamserver.model.Response;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for Response Method execute
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestExecute {

	@Test
	void testExecute() {
		Response testResponse = new Response(UI.ServerCodes.TODO, new Object[0]);
		assertNotNull(testResponse.execute());
	}

}
