package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager method getFirstFiftyArtworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetFirstFiftyArtworks {

	@Test
	void testIdOnlyInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getFirstFiftyArtworks(new Object[]{1}).getError());
	}

	@Test
	void testIdOnlyValid() {
		assertNotNull(ArtworkManager.getFirstFiftyArtworks(new Object[] {1.0}).getData());
	}

	@Test
	void testIdWithFollowingInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getFirstFiftyArtworks(new Object[]{1, "true"}).getError());
	}

	@Test
	void testIdWithFollowingValidFormat() {
		UserManager.addUser(new Object[] {"test", "test", "test@my.westga.edu"});
		ArtworkManager.addArtwork(new Object[]{new ArrayList<Double>(Arrays.asList(1.1, 2.2, 3.3)), "title", 1.0, new ArrayList<Integer>(), "2021-01-01"});
		assertNotNull(ArtworkManager.getFirstFiftyArtworks(new Object[] {0.0, false}).getData());
	}

}
