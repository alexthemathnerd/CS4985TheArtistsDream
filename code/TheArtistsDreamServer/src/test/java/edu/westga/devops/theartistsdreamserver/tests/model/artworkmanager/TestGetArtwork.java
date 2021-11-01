package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager Method getArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetArtwork {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getArtwork(new Object[] {"0"}).getError());
	}

	@Test
	void testValidFound() {
		ArtworkManager.addArtwork(new Object[] {new ArrayList<Double>(), "title", 1.0, new ArrayList<Integer>(), "2021-01-01"});
		assertNotNull(ArtworkManager.getArtwork(new Object[] {1}).getData());
	}

	@Test
	void testValidNotFound() {
		assertEquals(UI.ErrorMessages.ARTWORK_NOT_FOUND, ArtworkManager.getArtwork(new Object[] {111}).getError());
	}

}
