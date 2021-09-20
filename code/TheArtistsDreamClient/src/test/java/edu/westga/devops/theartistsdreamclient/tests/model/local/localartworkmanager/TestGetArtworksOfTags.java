package edu.westga.devops.theartistsdreamclient.tests.model.local.localartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalArtworkManager method getArtworksOfTags
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetArtworksOfTags {

	@Test
	void testEmptyManager() {
		LocalArtworkManager testManager = new LocalArtworkManager();
		assertEquals(0, testManager.getArtworksOfTags(new ArrayList<Tag>(Arrays.asList(new Tag(1, "test"), new Tag(2, "test2")))).size());
	}

	@Test
	void testNoArtworksMatch() {
		LocalArtworkManager testManager = new LocalArtworkManager();


		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 2, "2020-10-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 3, "2020-03-02"));

		List<Tag> tags = new ArrayList<Tag>(Arrays.asList(new Tag(1, "test"), new Tag(2, "test2")));
		assertEquals(0, testManager.getArtworksOfTags(tags).size());
	}

	@Test
	void testArtworksMatch() {
		LocalArtworkManager testManager = new LocalArtworkManager();

		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(Arrays.asList(1)), 1, "2020-02-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(Arrays.asList(2)), 2, "2020-10-02"));
		testManager.addArtwork(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(Arrays.asList(1)), 3, "2020-03-02"));

		List<Tag> tags = new ArrayList<Tag>(Arrays.asList(new Tag(1, "test"), new Tag(2, "test2")));
	}
}
