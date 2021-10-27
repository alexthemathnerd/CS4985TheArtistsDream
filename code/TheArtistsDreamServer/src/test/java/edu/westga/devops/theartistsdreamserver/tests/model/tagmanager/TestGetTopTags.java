package edu.westga.devops.theartistsdreamserver.tests.model.tagmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Tag;
import edu.westga.devops.theartistsdreamserver.model.TagManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * JUnit Test Case for TagManager Method getTopTags
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestGetTopTags {

    @Test
    void testInvalidArgument() {
        assertEquals(UI.ErrorMessages.INVALID_FORMAT, TagManager.getTopTags(new Object[] {1, 1}).getError());
    }

    @Test
    void testValidEmptyContent() {
            TheArtistsDreamServer.TAGS.clear();
            TagManager.addTag(new Object[] {"tag1"});
            TagManager.addTag(new Object[] {"tag2"});
            TagManager.addTag(new Object[] {"tag3"});


            assertEquals(0, ((List<Tag>)TagManager.getTopTags(new Object[] {1.0, ""}).getData()).size());
    }

    @Test
    void testValidEmptyManager() {
            TheArtistsDreamServer.TAGS.clear();
	    assertEquals(0, ((List<Tag>)TagManager.getTopTags(new Object[] {1.0, "tag"}).getData()).size());
    }

    @Test
    void testValidAmountLessThanSize() {
            TheArtistsDreamServer.TAGS.clear();
            TagManager.addTag(new Object[] {"tag1"});
            TagManager.addTag(new Object[] {"tag2"});
            TagManager.addTag(new Object[] {"tag3"});


            assertEquals(1, ((List<Tag>)TagManager.getTopTags(new Object[] {1.0, "tag"}).getData()).size());
    }


    @Test
    void testValidAmountGreaterThanSize() {
	    TheArtistsDreamServer.TAGS.clear();
	    TagManager.addTag(new Object[] {"tag1"});
	    TagManager.addTag(new Object[] {"tag2"});
	    TagManager.addTag(new Object[] {"tag3"});

	    assertEquals(3, ((List<Tag>) TagManager.getTopTags(new Object[] {5.0, "tag"}).getData()).size());
    }

    @Test
    void testValidAmountEqualToSize() {
            TheArtistsDreamServer.TAGS.clear();
            TagManager.addTag(new Object[] {"tag1"});
            TagManager.addTag(new Object[] {"tag2"});
            TagManager.addTag(new Object[] {"tag3"});


            assertEquals(3, ((List<Tag>)TagManager.getTopTags(new Object[] {3.0, "tag"}).getData()).size());
    }
}
