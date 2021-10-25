package edu.westga.devops.theartistsdreamserver.tests.model;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager Method getArtworksOfTags
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetArtworksOfTags {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getArtworksOfTags(new Object[] {"1.0"}).getError());
	}

	@Test
	void testValidFormat() {
		assertNotNull(ArtworkManager.getArtworksOfTags(new Object[] {new ArrayList<Object>()}).getData());
	}

}
