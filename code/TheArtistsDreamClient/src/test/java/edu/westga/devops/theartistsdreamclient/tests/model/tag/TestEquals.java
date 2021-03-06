package edu.westga.devops.theartistsdreamclient.tests.model.tag;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Case for Tag Method equals
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestEquals {

    @Test
    void testEqual() {
        Tag testTag = new Tag(1, "test");
        assertEquals(testTag, new Tag(1, "test2"));
    }

    @Test
    void testNotEqual() {
        Tag testTag = new Tag(1, "test");
        assertNotEquals(testTag, new Tag(2, "test2"));
    }
}
