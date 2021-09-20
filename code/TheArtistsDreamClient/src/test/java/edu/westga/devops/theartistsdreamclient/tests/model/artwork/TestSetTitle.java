package edu.westga.devops.theartistsdreamclient.tests.model.artwork;

import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Cases for LocalArtwork method setTitle
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSetTitle {


	@Test
	void testNullTitle() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertThrows(IllegalArgumentException.class, () -> testArtwork.setTitle(null));
	}

	@Test
	void testEmptyTitle() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertThrows(IllegalArgumentException.class, () -> testArtwork.setTitle(""));
	}

	@Test
	void testValidTitle() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		testArtwork.setTitle("new title");
		assertEquals("new title", testArtwork.getTitle());
	}
}
