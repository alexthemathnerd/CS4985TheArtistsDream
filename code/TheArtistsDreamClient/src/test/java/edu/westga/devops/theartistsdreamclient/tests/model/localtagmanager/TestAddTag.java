package edu.westga.devops.theartistsdreamclient.tests.model.localtagmanager;

import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddTag {

    @Test
    public void testWhenNameIsNull() {
        TagManager tagManager = new LocalTagManager();
        assertThrows(IllegalArgumentException.class, () -> {
            tagManager.addTag(null);
        });
    }

    @Test
    public void testWhenNameIsEmpty() {
        TagManager tagManager = new LocalTagManager();
        assertThrows(IllegalArgumentException.class, () -> {
            tagManager.addTag("");
        });
    }

    @Test
    public void testAddDiffrent() {
        TagManager tagManager = new LocalTagManager();
        tagManager.addTag("test1");
        int result = tagManager.addTag("test2");
        assertEquals(1, result);
    }

    @Test
    public void testAddDuplicate() {
        TagManager tagManager = new LocalTagManager();
        tagManager.addTag("test");
        int result = tagManager.addTag("test");
        assertEquals(0, result);
    }
}
