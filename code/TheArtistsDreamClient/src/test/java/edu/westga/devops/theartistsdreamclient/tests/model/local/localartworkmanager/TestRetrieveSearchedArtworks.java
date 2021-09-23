package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit test case for LocalArtworkManager method retrieve searched Artwork
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestRetrieveSearchedArtworks {
    @Test
    void testNullTitle() {
        LocalArtworkManager testManager = new LocalArtworkManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.retrieveSearchedArtwork(null));
    }  
    
    @Test
    void testEmptyTitle() {
        LocalArtworkManager testManager = new LocalArtworkManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.retrieveSearchedArtwork(""));
    }  

    @Test
    void testSearchedArtworkNotFound() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        testManager.addArtwork(new Artwork(new byte[0], "test1", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test2", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test3", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        assertNull(testManager.retrieveSearchedArtwork("test"));
    }

    @Test
    void testSearchedArtworkFound() {
        LocalArtworkManager testManager = new LocalArtworkManager();
        testManager.addArtwork(new Artwork(new byte[0], "test1", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test2", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test3", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
        assertNotNull(testManager.retrieveSearchedArtwork("test1"));
    }
}
