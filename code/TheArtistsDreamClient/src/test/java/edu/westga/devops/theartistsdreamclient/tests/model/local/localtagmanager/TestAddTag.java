package edu.westga.devops.theartistsdreamclient.tests.model.local.localtagmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalTagManager method addTag
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestAddTag {


    @Test
    void testAddToEmptyManager() {
        LocalTagManager testManager = new LocalTagManager();
        assertEquals(0, testManager.addTag("test"));
    }

    @Test
    void testAddAlreadyExistingTag() {
        LocalTagManager testManager = new LocalTagManager();
        testManager.addTag("test");
        testManager.addTag("test2");
        assertEquals(1, testManager.addTag("test2"));
    }

    @Test
    void testAddUniqueTag() {
        LocalTagManager testManager = new LocalTagManager();
        testManager.addTag("test");
        testManager.addTag("test2");
        assertEquals(2, testManager.addTag("test3"));
    }
}
