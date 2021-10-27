package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for LocalArtworkManager method addArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestAddArtwork {

    @Test
    void testEmptyManager() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        assertAll(() -> assertTrue(testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-10-20"))), () -> assertTrue(testManager.addArtwork(new byte[0], "test", 1, new ArrayList<Integer>(), "2020-10-20")));
    }

}
