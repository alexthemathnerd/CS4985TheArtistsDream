package edu.westga.devops.theartistsdreamclient.tests.model.tag;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Case for Tag Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {


    @Test
    void testNegativeId() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(-1, "test"));
    }

    @Test
    void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(1, null));
    }

    @Test
    void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(1, ""));
    }

    @Test
    void testValidParameters() {
        Tag testTag = new Tag(1, "test");
        assertAll(() -> assertEquals(1, testTag.getId()), () -> assertEquals("test", testTag.getName()), () -> assertEquals(1, testTag.getUseCount()));
    }

    @Test
    void testNegativeIdThreeParameter() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(-1, "test", 1));
    }

    @Test
    void testNullNameThreeParameter() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(1, null, 1));
    }

    @Test
    void testEmptyNameThreeParameter() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(1, "", 1));
    }

    @Test
    void testNegativeUseCount() {
        assertThrows(IllegalArgumentException.class, () -> new Tag(1, "test", -1));
    }

    @Test
    void testValidParametersThreeParameter() {
        Tag testTag = new Tag(1, "test", 2);
        assertAll(() -> assertEquals(1, testTag.getId()), () -> assertEquals("test", testTag.getName()), () -> assertEquals(2, testTag.getUseCount()));
    }
}
