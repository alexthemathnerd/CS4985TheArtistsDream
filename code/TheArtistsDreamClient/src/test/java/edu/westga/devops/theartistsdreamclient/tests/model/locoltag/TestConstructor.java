package edu.westga.devops.theartistsdreamclient.tests.model.locoltag;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the constructor of the {@link LocalTag}
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see LocalTag
 */
public class TestConstructor {

    @Test
    public void testNegativeId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalTag(-1, "test");
        });
    }

    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalTag(0, null);
        });
    }

    @Test
    public void testSuccessfulConstruction() {
        LocalTag tag = new LocalTag(0,"test");
        assertAll(() -> {
            assertEquals("test", tag.getName());
            assertEquals(1, tag.getUseCount());
        });
    }

}
