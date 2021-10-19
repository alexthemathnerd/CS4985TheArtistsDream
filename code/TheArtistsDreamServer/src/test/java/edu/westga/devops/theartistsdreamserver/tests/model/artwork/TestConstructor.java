package edu.westga.devops.theartistsdreamserver.tests.model;

import edu.westga.devops.theartistsdreamserver.model.Artwork;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for Artwork Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testNullImage() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(null, "title", 1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], null, 1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "", 1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testNegativeArtistsID() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", -1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testNullTagIDs() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, null, 1, "2020-01-01"));
	}

	@Test
	void testNegativeID() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, new ArrayList<Integer>(), -4, "2020-01-01"));
	}

	@Test
	void testNullDate() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, new ArrayList<Integer>(), 4, null));
	}

	@Test
	void testValidConstructorWithByteArray() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");

		assertAll(() -> assertNotNull(testArtwork.getImageData()), () -> assertEquals("title", testArtwork.getTitle()), () -> assertEquals(0, testArtwork.getArtistID()), () -> assertEquals(0, testArtwork.getTagIDs().size()), () -> assertEquals(1, testArtwork.getID()), () -> assertEquals("2020-01-01", testArtwork.getDate()));

	}

}
