package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalArtworkManager method size
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSize {

    @Test
    void testSize() {
        LocalArtworkManager testManager = new LocalArtworkManager();

        assertEquals(0, testManager.size());
    }

}
