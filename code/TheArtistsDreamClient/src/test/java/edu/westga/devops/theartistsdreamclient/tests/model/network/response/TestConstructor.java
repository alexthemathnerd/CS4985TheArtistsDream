package edu.westga.devops.theartistsdreamclient.tests.model.network.response;

import edu.westga.devops.theartistsdreamclient.model.network.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for Response Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

    @Test
    void testCreations() {
        Response<Integer> testResponse = new Response("test", 1);
        assertAll(() -> assertEquals("test", testResponse.getError()), () -> assertEquals(1, testResponse.getData()));
    }

}

