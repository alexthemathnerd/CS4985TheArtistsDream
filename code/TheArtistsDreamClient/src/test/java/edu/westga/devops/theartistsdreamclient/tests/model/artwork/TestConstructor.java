package edu.westga.devops.theartistsdreamclient.tests.model.artwork;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit Test Cases for Artwork Constructor
 *
 * @author Aznella Joseph
 * @author Alexander Schmidt
 * @version Fall 2021
 */

@ExtendWith(MockitoExtension.class)
public class TestConstructor {

    @Mock
    private Image image;

    @Test
    void testNullImage() {
        assertThrows(IllegalArgumentException.class, () -> new Artwork((Image) null, "title", 1, new ArrayList<>(), 1, "2020-01-01"));
    }

    @Test
    void testNullByteArray() {
        assertThrows(IllegalArgumentException.class, () -> new Artwork((byte[]) null, "title", 1, new ArrayList<>(), 1, "2020-01-01"));
    }

    @Test
    void testNullTitle() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), null, 1, new ArrayList<>(), 1, "2020-01-01"));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], null, 1, new ArrayList<>(), 1, "2020-01-01"));
        });

    }

    @Test
    void testEmptyTitle() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "", 1, new ArrayList<>(), 1, "2020-01-01"));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "", 1, new ArrayList<>(), 1, "2020-01-01"));
        });
    }

    @Test
    void testNegativeArtistsID() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", -1, new ArrayList<>(), 1, "2020-01-01"));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", -1, new ArrayList<>(), 1, "2020-01-01"));
        });

    }

    @Test
    void testNullTagIDs() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, null, 1, "2020-01-01"));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, null, 1, "2020-01-01"));
        });
    }

    @Test
    void testNegativeID() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, new ArrayList<>(), -4, "2020-01-01"));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, new ArrayList<>(), -4, "2020-01-01"));
        });
    }

    @Test
    void testNullDate() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, new ArrayList<>(), 0, null));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, new ArrayList<>(), 0, null));
        });

    }

    @Test
    void testEmptyDate() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new Image("icon.png"), "title", 1, new ArrayList<>(), 0, ""));
            assertThrows(IllegalArgumentException.class, () -> new Artwork(new byte[0], "title", 1, new ArrayList<>(), 0, ""));
        });

    }

    @Test
    void testValidConstructorWithByteArray() {
        Artwork testArtwork = new Artwork(new byte[0], "title", 0, new ArrayList<>(), 1, "2020-01-01");
        assertAll(() -> assertNotNull(testArtwork.getImage()), () -> assertEquals("title", testArtwork.getTitle()), () -> assertEquals(0, testArtwork.getArtistID()), () -> assertEquals(0, testArtwork.getTagIDs().size()), () -> assertEquals(1, testArtwork.getID()), () -> assertEquals("2020-01-01", testArtwork.getDate()));
    }

    @Test
    void testValidConstructorWithImage() {
        Artwork testArtwork = new Artwork(this.image, "title", 0, new ArrayList<>(), 1, "2020-01-01");
        assertAll(() -> assertNotNull(testArtwork.getImage()), () -> assertEquals("title", testArtwork.getTitle()), () -> assertEquals(0, testArtwork.getArtistID()), () -> assertEquals(0, testArtwork.getTagIDs().size()), () -> assertEquals(1, testArtwork.getID()), () -> assertEquals("2020-01-01", testArtwork.getDate()));
    }

}
