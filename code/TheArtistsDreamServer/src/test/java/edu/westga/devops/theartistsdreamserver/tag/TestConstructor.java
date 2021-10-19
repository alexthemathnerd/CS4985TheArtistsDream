package edu.westga.devops.theartistsdreamserver.tag;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Junit test class for the constructor in the tag class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestConstructor {
    @Test
    void TestConstructor() {
        Tag testTag = new Tag(0,"Test");
        assertAll(
            () -> assertEquals(0, testTag.getId()), 
            () -> assertEquals("test", testTag.getName()), 
            () -> assertEquals(1, testTag.getUseCount()));
    }
}