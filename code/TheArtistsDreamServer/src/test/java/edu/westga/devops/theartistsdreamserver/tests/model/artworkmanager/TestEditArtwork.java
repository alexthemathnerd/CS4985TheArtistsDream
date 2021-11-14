package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Artwork;
import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit Test Case for ArtworkManager Method editArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestEditArtwork {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.editArtwork(new Object[] {1, 2}).getError());
	}

	@Test
	void testValidFormatArtworkDoesNotExist() {
		assertEquals(UI.ErrorMessages.ARTWORK_NOT_FOUND, ArtworkManager.editArtwork(new Object[] {100.0, "new"}).getError());
	}

	@Test
	void testValidArtworkExists() {
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "hello", 0, new ArrayList<>(), 0, LocalDate.now().toString()));
		ArtworkManager.addArtwork(new Object[]{new ArrayList<Double>(Arrays.asList(1.1, 2.2, 3.3)), "title", 1.0, new ArrayList<Integer>(), "2021-01-01"});
		assertTrue((boolean) ArtworkManager.editArtwork(new Object[] {0.0, "new"}).getData());
	}

}
