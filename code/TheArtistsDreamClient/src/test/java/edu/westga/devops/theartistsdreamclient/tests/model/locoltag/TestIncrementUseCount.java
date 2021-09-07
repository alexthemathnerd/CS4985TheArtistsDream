package edu.westga.devops.theartistsdreamclient.tests.model.locoltag;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the incrementUseCount of the {@link LocalTag}
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see LocalTag
 */
public class TestIncrementUseCount {

    @Test
    public void testSuccesfulIncrement() {
        LocalTag tag = new LocalTag("Test");
        tag.incrementUseCount();
        assertEquals(2, tag.getUseCount());
    }

}
