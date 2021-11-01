package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Case for LocalArtworkManager method removeArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestRemoveArtwork {

    @Test
    void testFromEmptyManager() {
        LocalArtworkManager testManager = new LocalArtworkManager();

        assertFalse(testManager.removeArtwork(1));
    }

    @Test
    void testRemoveFirst() {
        LocalArtworkManager testManager = new LocalArtworkManager();

        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 2, "2020-10-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 3, "2020-03-02"));

        boolean remove = testManager.removeArtwork(1);
        assertAll(() -> assertEquals(2, testManager.size()), () -> assertTrue(remove));
    }

    @Test
    void testRemoveSecond() {
        LocalArtworkManager testManager = new LocalArtworkManager();

        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 2, "2020-10-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 3, "2020-03-02"));

        boolean remove = testManager.removeArtwork(2);
        assertAll(() -> assertEquals(2, testManager.size()), () -> assertTrue(remove));
    }

    @Test
    void testRemoveLast() {
        LocalArtworkManager testManager = new LocalArtworkManager();

        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 2, "2020-10-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 3, "2020-03-02"));

        boolean remove = testManager.removeArtwork(3);
        assertAll(() -> assertEquals(2, testManager.size()), () -> assertTrue(remove));
    }

}
