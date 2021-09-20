package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalArtworkManager Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

	@Test
	void testListCreation() {
		LocalArtworkManager testManager = new LocalArtworkManager();
		assertEquals(0, testManager.size());
	}
}
