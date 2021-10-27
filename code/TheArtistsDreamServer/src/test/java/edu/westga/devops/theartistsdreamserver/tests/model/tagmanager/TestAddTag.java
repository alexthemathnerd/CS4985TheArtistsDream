package edu.westga.devops.theartistsdreamserver.tests.model.tagmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.TagManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

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
    void testValidNonexistingTagEmptyManager() {
	    TheArtistsDreamServer.TAGS.clear();
	    assertEquals(0, TagManager.addTag(new Object[] {"tag"}).getData());
     }

    @Test
    void testValidNonexistingTagNonemptyManager() {
            TheArtistsDreamServer.TAGS.clear();
            TagManager.addTag(new Object[] {"test"});
            TagManager.addTag(new Object[] {"devops"});
            assertEquals(0, TagManager.addTag(new Object[] {"test"}).getData());
    }

    @Test
    void testValidExistingTag() {
	    TheArtistsDreamServer.TAGS.clear();
	    TagManager.addTag(new Object[] {"tag"});
	    assertEquals(0, (int) TagManager.addTag(new Object[] {"TAG"}).getData());
    }
}
