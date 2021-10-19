package edu.westga.devops.theartistsdreamserver.tagmanager;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.List;

/**
 * Junit test class for the method getTopTags in the tag manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestGetTopTags {
    @Test
    void TestInvalidArgument() {
        TheArtistsDreamServer.TAGS.clear();
        TagManager testTagManager = new TagManager();
        Object[] argument = new Object[] {new Object(), new Object()};
        assertEquals(UI.ErrorMessages.INVALID_FORMAT, testTagManager.getTopTags(argument).getError());
    }

    @Test
    void TestGetTopTags() {
        TheArtistsDreamServer.TAGS.clear();
        TagManager testTagManager = new TagManager();
        testTagManager.addTag(new Object[]{"test"});
        testTagManager.addTag(new Object[]{"test1"});
        testTagManager.addTag(new Object[]{"test2"});
        testTagManager.addTag(new Object[]{"add"});
        Object[] argument = new Object[] {2.0, "test"};
        assertEquals(2, ((List) testTagManager.getTopTags(argument).getData()).size());
    }


}
