package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit test case for LocalArtworkManager method search for Artworks
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestSearchForArtworks {
    @Test
    void testNullSearchTerm() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        assertThrows(IllegalArgumentException.class, () -> testManager.searchForArtworks(null));
    }

    @Test
    void testSearchEmptyManager() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        List<Artwork> testSearchedArtworks = testManager.searchForArtworks("a");
        assertEquals(0, testSearchedArtworks.size());
    }

    @Test
    void testSearchNoArtworksFound() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        testManager.addArtwork(new Artwork(new byte[0], "test1", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test2", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test3", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        List<Artwork> testSearchedArtworks = testManager.searchForArtworks("a");
        assertEquals(0, testSearchedArtworks.size());
    }

    @Test
    void testSearchArtworksFound() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        testManager.addArtwork(new Artwork(new byte[0], "test1", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test2", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        testManager.addArtwork(new Artwork(new byte[0], "test3", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        List<Artwork> testSearchedArtworks = testManager.searchForArtworks("test");
        assertEquals(3, testSearchedArtworks.size());
    }
}
