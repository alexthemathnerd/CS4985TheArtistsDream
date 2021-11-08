package edu.westga.devops.theartistsdreamserver.tests.model.artwork;

import edu.westga.devops.theartistsdreamserver.model.Artwork;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for Artwork Method setTitle
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSetTitle {

	@Test
	void testInvalidNewTitle() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, testArtwork.setTitle(new Object[]{1}).getError());
	}

	@Test
	void testValidNewTitle() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertEquals("new title", testArtwork.setTitle(new Object[]{"new title"}).getData());
	}

}
