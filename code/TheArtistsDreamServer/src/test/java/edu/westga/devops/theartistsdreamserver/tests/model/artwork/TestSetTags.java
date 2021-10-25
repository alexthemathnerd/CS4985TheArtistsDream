package edu.westga.devops.theartistsdreamserver.tests.model;

import edu.westga.devops.theartistsdreamserver.model.Artwork;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for Artwork Method setTags
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSetTags {

	@Test
	void testNewTagsInInvalidFormat() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertEquals("Invalid Format", testArtwork.setTags(new Object[]{1, 2}).getError());
	}

	@Test
	void testValidNewTags() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertNotNull(testArtwork.setTags(new Object[]{new ArrayList<Integer>(Arrays.asList(1, 2))}).getData());
	}

}
