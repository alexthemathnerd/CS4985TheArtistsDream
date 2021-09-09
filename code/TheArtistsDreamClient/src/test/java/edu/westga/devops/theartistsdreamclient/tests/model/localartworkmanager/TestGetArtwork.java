package edu.westga.devops.theartistsdreamclient.tests.model.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * JUnit Tests for LocalArtworkManager method getArtwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetArtwork {


	@Test
	void testEmptyManager() {
		LocalArtworkManager testManager = new LocalArtworkManager();
		assertNull(testManager.getArtwork(0));
	}

}
