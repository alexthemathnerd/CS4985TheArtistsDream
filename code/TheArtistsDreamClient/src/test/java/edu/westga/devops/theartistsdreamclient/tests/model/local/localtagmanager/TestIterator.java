package edu.westga.devops.theartistsdreamclient.tests.model.local.localtagmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for LocalTagManager method iterator
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestIterator {

    @Test
    void testIterator() {
        LocalTagManager testManager = new LocalTagManager();
        assertNotNull(testManager.iterator());
    }
}
