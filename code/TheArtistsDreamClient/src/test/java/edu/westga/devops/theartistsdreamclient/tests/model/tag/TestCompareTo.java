package edu.westga.devops.theartistsdreamclient.tests.model.tag;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for Tag Method compareTo
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestCompareTo {

    @Test
    void testNullOtherTag() {
        Tag testTag = new Tag(1, "test");
        assertThrows(NullPointerException.class, () -> testTag.compareTo(null));
    }

    @Test
    void testSameUseCount() {
        Tag testTag = new Tag(1, "test");
        Tag testTag2 = new Tag(2, "test2");
        assertEquals(-1, testTag.compareTo(testTag2));
    }

    @Test
    void testDifferentUseCounts() {
        Tag testTag = new Tag(1, "test");
        Tag testTag2 = new Tag(1, "test", 3);
        assertEquals(2, testTag.compareTo(testTag2));
    }

}
