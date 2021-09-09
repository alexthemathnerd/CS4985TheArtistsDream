package edu.westga.devops.theartistsdreamclient.tests.model.localtag;

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
        LocalTag tag = new LocalTag(0,"test");
        assertThrows(NullPointerException.class, () -> {
            tag.compareTo(null);
        });
    }

    @Test
    public void testWhenLessThanNotEqualUseCount() {
        LocalTag tag1 = new LocalTag(0,"test1");
        LocalTag tag2 = new LocalTag(1,"test1");
        tag1.incrementUseCount();
        int result = tag1.compareTo(tag2);
        assertTrue(result < 0);
    }

    @Test
    public void testWhenLessThanEqualUseCount() {
        LocalTag tag1 = new LocalTag(0,"test1");
        LocalTag tag2 = new LocalTag(1,"test2");
        int result = tag1.compareTo(tag2);
        assertTrue(result < 0);
    }

    @Test
    public void testWhenEqual() {
        LocalTag tag1 = new LocalTag(0,"test1");
        LocalTag tag2 = new LocalTag(0,"test1");
        int result = tag1.compareTo(tag2);
        assertTrue(result == 0);
    }

    @Test
    public void testWhenGreaterThanEqualUseCount() {
        LocalTag tag1 = new LocalTag(1,"test1");
        LocalTag tag2 = new LocalTag(0,"test0");
        int result = tag1.compareTo(tag2);
        assertTrue(result > 0);
    }

    @Test
    public void testWhenGreaterThanNotEqualUseCount() {
        LocalTag tag1 = new LocalTag(0,"test1");
        LocalTag tag2 = new LocalTag(1,"test1");
        tag2.incrementUseCount();
        int result = tag1.compareTo(tag2);
        assertTrue(result > 0);
    }

}
