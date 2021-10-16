package edu.westga.devops.theartistsdreamclient.tests.model.artwork;

import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.ArrayList;
import javafx.scene.image.Image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import static org.mockito.Mockito.*;


/**
 * JUnit Test Cases for Artwork Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */

@ExtendWith(MockitoExtension.class)
public class TestConstructor {
	
	@Mock
	private Image image;

	@BeforeAll
	public static void setup() throws Exception {
		MockitoAnnotations.initMocks(new TestConstructor());
	}

	@Test
	void testNullImage() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image(""), "title", 1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), null, 1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "", 1, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testArtistsIDZero() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 0, new ArrayList<Integer>(), 1, "2020-01-01"));
	}

	@Test
	void testNullTagIDs() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, null, 1, "2020-01-01"));
	}

	@Test
	void testNegativeID() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, new ArrayList<Integer>(), -4, "2020-01-01"));
	}

	@Test
	void testNullDate() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, new ArrayList<Integer>(), -4, null));
	}

	@Test
	void testEmptyDate() {
		assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, new ArrayList<Integer>(), -4, ""));
	}

	@Test
	void testValidConstructorWithByteArray() {
		Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");

		assertAll(() -> assertNotNull(testArtwork.getImage()), () -> assertEquals("title", testArtwork.getTitle()), () -> assertEquals(0, testArtwork.getArtistID()), () -> assertEquals(0, testArtwork.getTagIDs().size()), () -> assertEquals(1, testArtwork.getID()), () -> assertEquals("2020-01-01", testArtwork.getDate()));

	}

	@Test
	void testValidConstructorWithImage() {
		Artwork testArtwork = new Artwork(this.image, "title", 0, new ArrayList<Integer>(), 1, "2020-01-01");
		assertAll(() -> assertNotNull(testArtwork.getImage()), () -> assertEquals("title", testArtwork.getTitle()), () -> assertEquals(0, testArtwork.getArtistID()), () -> assertEquals(0, testArtwork.getTagIDs().size()), () -> assertEquals(1, testArtwork.getID()), () -> assertEquals("2020-01-01", testArtwork.getDate()));
	}

}
