package edu.westga.devops.theartistsdreamserver.tests.model.artwork;

import edu.westga.devops.theartistsdreamserver.model.Artwork;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for Artwork Overriden Method compareTo
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestCompareTo {

	@Test
	void testParamLessThan() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-02");
		assertEquals(1, testArtwork.compareTo(new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-03")));
	}

	@Test
	void testParamGreaterThan() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-02");
		assertEquals(-1, testArtwork.compareTo(new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01")));
	}

	@Test
	void testEqual() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertEquals(0, testArtwork.compareTo(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 2, "2020-01-01")));
	}

}
