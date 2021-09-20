package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for LocalArtworkManager Method getArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetArtwork {

	@Test
	void testNewArtworkManager() {
		LocalArtworkManager testManager = new LocalArtworkManager();

		assertNull(testManager.getArtwork(1));
	}

	@Test
	void testWrongIdNumber() {
		LocalArtworkManager testManager = new LocalArtworkManager();

		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		assertNull(testManager.getArtwork(5));
	}

	@Test
	void testValidId() {
		                LocalArtworkManager testManager = new LocalArtworkManager();

                testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
                assertNotNull(testManager.getArtwork(1));
	}

}

