package edu.westga.devops.theartistsdreamclient.tests.model.localartwork;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtwork;

import java.util.ArrayList;
import javafx.scene.image.Image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Cases for LocalArtwork Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

	@Test
	void testNullImage() {
		assertThrows(IllegalArgumentException.class, () -> new LocalArtwork(null, "title", 1, new ArrayList<Integer>(), 1));
	}

	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, () -> new LocalArtwork(new Image("icon.png"), null, 1, new ArrayList<Integer>(), 1));
	}

	@Test
	void testEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> new LocalArtwork(new Image("icon.png"), "", 1, new ArrayList<Integer>(), 1));
	}

	@Test
	void testArtistsIDZero() {
		assertThrows(IllegalArgumentException.class, () -> new LocalArtwork(new Image("icon.png"), "title", 0, new ArrayList<Integer>(), 1));
	}

	@Test
	void testNullTagIDs() {
		assertThrows(IllegalArgumentException.class, () -> new LocalArtwork(new Image("icon.png"), "title", 1, null, 1));
	}

	@Test
	void testNegativeID() {
		assertThrows(IllegalArgumentException.class, () -> new LocalArtwork(new Image("icon.png"), "title", 1, new ArrayList<Integer>(), -4));
	}

	//TODO: Add valid parameter test case. Use icon image

}
