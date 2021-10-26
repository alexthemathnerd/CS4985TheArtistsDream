package edu.westga.devops.theartistsdreamclient.tests.viewmodel.artworkspaneviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Case for ArtworksPaneViewModel Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testPropertyCreations() {
		ArtworksPaneViewModel testViewModel = new ArtworksPaneViewModel();
		assertAll(
				() -> assertNotNull(testViewModel.artworksProperty()),
				() -> assertNotNull(testViewModel.filterTagsProperty()),
				() -> assertEquals(0, testViewModel.indexProperty().get()),
				() -> assertEquals(50, testViewModel.maxIndexProperty().get()),
				() -> assertEquals(-1, testViewModel.userIdProperty().get()),
				() -> assertTrue(testViewModel.onFollowingPageProperty().get()));
	}

}
