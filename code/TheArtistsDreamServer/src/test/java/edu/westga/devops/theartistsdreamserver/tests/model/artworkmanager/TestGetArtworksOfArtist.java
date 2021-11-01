package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager Method getArtworksOfArtist
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetArtworksOfArtist {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getArtworksOfArtist(new Object[] {"1.0"}).getError());
	}

	@Test
	void testValidFormat() {
		assertNotNull(ArtworkManager.getArtworksOfArtist(new Object[] {1.0}).getData());
	}

}
