package edu.westga.devops.theartistsdreamclient.tests.model.artwork;

import java.util.ArrayList;
import java.util.Arrays;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.Tag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Cases for LocalArtwork Method setTags
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSetTags {

	@Test
	void testNullNewTags() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertThrows(IllegalArgumentException.class, () -> testArtwork.setTags(null));
	}

	@Test
	void testValidNewTags() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		testArtwork.setTags(new ArrayList<Integer>(Arrays.asList(1, 2)));
				assertEquals(2, testArtwork.getTagIDs().size());
	}

}
