package edu.westga.devops.theartistsdreamclient.tests.model.tagmanager;

import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for TagManager Method setTagManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSetTagManager {

        @Test
        void setToNewTagManager() {
                TagManager.setTagManager(new LocalTagManager());
                assertNotNull(TagManager.getTagManager());
        }

        @Test
        void setToNull() {
                assertThrows(IllegalArgumentException.class, () -> TagManager.setTagManager(null));
        }

}

