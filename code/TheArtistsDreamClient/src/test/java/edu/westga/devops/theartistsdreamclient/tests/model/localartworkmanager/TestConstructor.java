package edu.westga.devops.theartistsdreamclient.tests.model.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * JUnit Tests to test the Constructor of LocalArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {


	@Test
	void testListCreation() {
		LocalArtworkManager testManager = new LocalArtworkManager();
		assertTrue(testManager.getFirstFiftyArtworks().isEmpty());
	}


}
