package edu.westga.devops.theartistsdreamserver.tests.model.tagmanager;

import edu.westga.devops.theartistsdreamserver.model.TagManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Junit test class for the method getTopTags in the tag manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestGetTopTags {

    @Test
    void TestInvalidArgument() {
        assertEquals(UI.ErrorMessages.INVALID_FORMAT, TagManager.getTopTags(new Object[] {1, 1}).getError());
    }

    @Test
    void TestValidArguments() { 
        assertNotNull(TagManager.getTopTags(new Object[] {1.0, "test"}).getData());
    }

}
