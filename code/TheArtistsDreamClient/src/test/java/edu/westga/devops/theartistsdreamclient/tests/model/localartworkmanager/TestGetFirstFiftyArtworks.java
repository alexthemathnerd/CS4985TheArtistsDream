package edu.westga.devops.theartistsdreamclient.tests.model.localartworkmanager;

/**
 * JUnit Test Cases for LocalArtworkManager Method getFirstFiftyArtworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetFirstFiftyArtworks {

	@Test
	void testNewLocalArtworkManager() {
		ArtworkManager testManager = new LocalArtworkManager();
		assertTrue(testManager.getFirstFiftyArtworks().size() == 0);
	}

}
