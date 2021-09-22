package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.utils.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        List<Artwork> testSearchedArtworks = testManager.searchedForArtworks("a");
        assertEquals(0, testSearchedArtworks.size());
    }

    @Test
    void testSearchNoArtworksFound() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        testManager.addArtwork(new Artwork(new byte[0], "test1", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test2", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test3", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        List<Artwork> testSearchedArtworks = testManager.searchedForArtworks("a");
        assertEquals(0, testSearchedArtworkss.size());
    }

    @Test
    void testSearchArtworksFound() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        testManager.addArtwork(new Artwork(new byte[0], "test1", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test2", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test3", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        List<Artwork> testSearchedArtworks = testManager.searchedForArtworks("test");
        assertEquals(3, testSearchedArtworkss.size());
    }    
}
