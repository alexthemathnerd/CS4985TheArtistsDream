package edu.westga.devops.theartistsdreamclient.tests.model.locoltag;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests that the {@link LocalTag} compare to methods functions as attended
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see LocalTag
 * @see Comparable
 */
public class TestCompareTo {

    @Test
    public void testWhenNull() {
        LocalTag tag = new LocalTag("test");
        assertThrows(NullPointerException.class, () -> {
            tag.compareTo(null);
        });
    }

    @Test
    public void testWhenLessThanNotEqualUseCount() {
        LocalTag tag1 = new LocalTag("test1");
        LocalTag tag2 = new LocalTag("test1");
        tag1.incrementUseCount();
        int result = tag1.compareTo(tag2);
        assertTrue(result < 0);
    }

    @Test
    public void testWhenLessThanEqualUseCount() {
        LocalTag tag1 = new LocalTag("test1");
        LocalTag tag2 = new LocalTag("test2");
        int result = tag1.compareTo(tag2);
        assertTrue(result < 0);
    }

    @Test
    public void testWhenEqual() {
        LocalTag tag1 = new LocalTag("test1");
        LocalTag tag2 = new LocalTag("test1");
        int result = tag1.compareTo(tag2);
        assertTrue(result == 0);
    }

    @Test
    public void testWhenGreaterThanEqualUseCount() {
        LocalTag tag1 = new LocalTag("test1");
        LocalTag tag2 = new LocalTag("test0");
        int result = tag1.compareTo(tag2);
        assertTrue(result > 0);
    }

    @Test
    public void testWhenGreaterThanNotEqualUseCount() {
        LocalTag tag1 = new LocalTag("test1");
        LocalTag tag2 = new LocalTag("test1");
        tag2.incrementUseCount();
        int result = tag1.compareTo(tag2);
        assertTrue(result > 0);
    }

}
