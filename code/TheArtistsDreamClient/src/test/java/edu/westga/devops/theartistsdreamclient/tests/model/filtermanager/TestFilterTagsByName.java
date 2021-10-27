package edu.westga.devops.theartistsdreamclient.tests.model.filtermanager;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for FilterManager Method filterTagsByName
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestFilterTagsByName {

    @Test
    void testNullManager() {
        assertThrows(IllegalArgumentException.class, () -> FilterManager.filterTagsByName(null, "test"));
    }

    @Test
    void testEmptyContent() {
        assertEquals(0, FilterManager.filterTagsByName(new LocalTagManager(), "").size());
    }

    @Test
    void testNullContent() {
        assertThrows(IllegalArgumentException.class, () -> FilterManager.filterTagsByName(new LocalTagManager(), null));
    }

    @Test
    void testValidParameters() {
        TagManager testManager = new LocalTagManager();
        testManager.addTag("test");
        List<Tag> testTagsList = FilterManager.filterTagsByName(testManager, "Test");
        assertEquals(1, testTagsList.size());
    }

}
