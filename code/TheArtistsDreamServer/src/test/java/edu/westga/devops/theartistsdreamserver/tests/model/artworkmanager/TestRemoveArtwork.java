package edu.westga.devops.theartistsdreamserver.tests.model;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for ArtworkManager removeArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestRemoveArtwork {

	@Test
	void testInvalidDataForArtwork() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.removeArtwork(new Object[]{"remove"}).getError());
	}

	@Test
	void testValidDataArtworkDoesNotExist() {
		assertEquals(UI.ErrorMessages.ARTWORK_NOT_FOUND, ArtworkManager.removeArtwork(new Object[]{101.0}).getError());
	}

	@Test
	void testValidDataArtworkExists() {
		ArtworkManager.addArtwork(new Object[]{new ArrayList<Double>(Arrays.asList(1.1, 2.2, 3.3)), "title", 1.0, new ArrayList<Integer>(), "2021-01-01"});
		assertTrue((boolean) ArtworkManager.removeArtwork(new Object[]{1.0}).getData());
	}

}
