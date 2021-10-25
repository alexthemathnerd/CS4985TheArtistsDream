package edu.westga.devops.theartistsdreamclient.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for User Method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetArtworkManager {

	@BeforeEach
	void init() {
		ArtworkManager.setArtworkManager(null);
	}

	@Test
	void testNull() {
		assertNull(ArtworkManager.getArtworkManager());
	}

	@Test
	void testNotNull() {
		ArtworkManager.setArtworkManager(new LocalArtworkManager());
		assertNotNull(ArtworkManager.getArtworkManager());
	}
}

