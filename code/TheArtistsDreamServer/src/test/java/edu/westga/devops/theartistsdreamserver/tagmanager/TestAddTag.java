package edu.westga.devops.theartistsdreamserver.tagmanager;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Test class for the add Tag method in the tag manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestAddTag {
    @Test
    void TestInvalidArgument() {
        TagManager testTagManager = new TagManager();
        Object[] argument = new Object[] {new Object()};
        assertEquals("Invalid format", TagManager.addTag(argument).getError());
    }

    @Test
    void testAddToEmptyManager() {
         TagManager testTagManager = new TagManager();
         Object[] argument = new Object[] {"tag"};
         assertAll(
            () -> assertEquals(0, TagManager.addTag(argument).getData()),
            () -> assertEquals(1, TheArtistsDreamServer.TAGS.size()));
     }

    @Test
    void testAddAlreadyExistingTag() {
        TheArtistsDreamServer.TAGS.clear();
        TagManager testTagManager = new TagManager();
         Object[] argument = new Object[] {"tag"};
         TagManager.addTag(argument);
         assertAll(
            () -> assertEquals(0, TagManager.addTag(argument).getData()),
            () -> assertEquals(1, TheArtistsDreamServer.TAGS.size()));
    }

    @Test 
    void testAddMutipleTags() {
        TheArtistsDreamServer.TAGS.clear();
        TagManager testTagManager = new TagManager();
        TagManager.addTag(new Object[]{"test1"});
        TagManager.addTag(new Object[]{"test2"});
        TagManager.addTag(new Object[]{"test3"});
        assertEquals(3, TheArtistsDreamServer.TAGS.size());
    }
}