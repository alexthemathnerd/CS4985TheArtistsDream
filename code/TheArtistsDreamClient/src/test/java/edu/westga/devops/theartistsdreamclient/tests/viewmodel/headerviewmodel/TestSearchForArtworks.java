package edu.westga.devops.theartistsdreamclient.tests.viewmodel.headerviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.HeaderViewModel;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for HeaderViewModel Method searchForArtworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSearchForArtworks {

	@Test
	void testEmptyManager() {
		ArtworkManager.setArtworkManager(new LocalArtworkManager());
		HeaderViewModel testViewModel = new HeaderViewModel();

		assertEquals(0, testViewModel.searchForArtworks("test").size());
	}

}
