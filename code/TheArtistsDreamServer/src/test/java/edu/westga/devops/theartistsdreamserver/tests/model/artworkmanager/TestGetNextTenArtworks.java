package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.Artwork;
import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.ArrayList;

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
		TheArtistsDreamServer.USERS.add(new User(0, "test@my.westga.edu", "test", "test123", new byte[0]));
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 0, "2021-10-10"));
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
