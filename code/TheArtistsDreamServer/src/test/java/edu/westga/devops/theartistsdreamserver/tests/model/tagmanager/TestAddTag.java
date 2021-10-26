package edu.westga.devops.theartistsdreamserver.tests.model.tagmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.TagManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for TagManager Method addTag
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestAddTag {

    @Test
    void TestInvalidArgument() {
        assertEquals(UI.ErrorMessages.INVALID_FORMAT, TagManager.addTag(new Object[] {1}).getError());
    }

    @Test
    void testValidNonexistingTag() {
	    assertNotNull(TagManager.addTag(new Object[] {"tag"}).getData());
     }

    @Test
    void testValidExistingTag() {
	    TagManager.addTag(new Object[] {"tag"});
	    assertEquals(0, (int) TagManager.addTag(new Object[] {"TAG"}).getData());
    }
}
