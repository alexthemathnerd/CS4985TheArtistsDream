package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * JUnit Test Case for LocalArtworkManager method editArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestEditArtwork {

	@Test
	void testNullNewTitle() {
		LocalArtworkManager testManager = new LocalArtworkManager();

		assertThrows(IllegalArgumentException.class, () -> testManager.editArtwork(1, null, new ArrayList<Integer>()));
	}

	@Test
	void testEmptyNewTitle() {
		LocalArtworkManager testManager = new LocalArtworkManager();

		assertThrows(IllegalArgumentException.class, () -> testManager.editArtwork(1, "", new ArrayList<Integer>()));
	}

	@Test
	void testNullNewTagIDs() {
		LocalArtworkManager testManager = new LocalArtworkManager();

		assertThrows(IllegalArgumentException.class, () -> testManager.editArtwork(1, "test", null));
	}

	@Test
	void testValidParameters() {
		LocalArtworkManager testManager = new LocalArtworkManager();
		        
                testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
                assertTrue(testManager.editArtwork(1, "test2", new ArrayList<Integer>(Arrays.asList(1, 2))));
        }

	@Test
	void testArtworkIdDoesNotExist() {
       
                LocalArtworkManager testManager = new LocalArtworkManager();

                testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));

		assertFalse(testManager.editArtwork(3, "test", new ArrayList<Integer>()));

        }


}
