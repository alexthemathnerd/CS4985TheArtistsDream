package edu.westga.devops.theartistsdreamclient.tests.model.tagmanager;

import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for User Method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetTagManager {

        @Test
        void testNull() {
                assertNull(TagManager.getTagManager());
        }

        @Test
        void testNotNull() {
                TagManager.setTagManager(new LocalTagManager());
                assertNotNull(TagManager.getTagManager());
        }
}

