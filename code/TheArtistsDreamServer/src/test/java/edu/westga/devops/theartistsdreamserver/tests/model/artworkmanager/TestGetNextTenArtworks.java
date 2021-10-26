package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager Method getNextTenArtworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetNextTenArtworks {

	@Test
	void testIndexAndIdInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getNextTenArtworks(new Object[] {1, 1}).getError());
	}

	@Test
	void testIndexAndIdValidFormat() {
		assertNotNull(ArtworkManager.getNextTenArtworks(new Object[] {0.0, 0.0}).getData());
	}

	@Test
	void testIndexOnlyInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getNextTenArtworks(new Object[] {1}).getError());
	}

	@Test
	void testIndexOnlyValidFormat() {
		assertNotNull(ArtworkManager.getNextTenArtworks(new Object[] {0.0}).getData());
	}

}
