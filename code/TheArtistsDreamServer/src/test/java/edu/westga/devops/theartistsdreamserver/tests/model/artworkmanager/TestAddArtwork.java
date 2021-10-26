package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager addArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestAddArtwork {

	@Test
	void testInvalidDataForArtwork() {
		assertNotNull(ArtworkManager.addArtwork(new Object[]{1, 2, 3, 4, 5}).getError());
	}

	@Test
	void testValidDataForArtwork() {
		assertTrue((boolean) ArtworkManager.addArtwork(new Object[]{new ArrayList<Double>(Arrays.asList(1.1, 2.2, 3.3)), "title", 1.0, new ArrayList<Integer>(), "2021-01-01"}).getData());
	}

}
