package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Request;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.Artwork;
import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Case for ArtworkManager Method getNextTenArtworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetNextTenArtworks {

	@BeforeEach
	void init() {
		TheArtistsDreamServer.ARTWORKS.clear();
		TheArtistsDreamServer.USERS.clear();
	}

	@Test
	void testIndexAndIdInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getNextTenArtworks(new Object[] {1, 1}).getError());
	}

	@Test
	void testIndexAndIdValidFormat() {
		TheArtistsDreamServer.USERS.add(new User(0, "test@my.westga.edu", "test", "test123", new byte[0]));
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), 0, "2021-10-10"));
		assertNotNull(ArtworkManager.getNextTenArtworks(new Object[] {0.0, 0.0}).getData());
	}

	@Test
	void testIndexOnlyInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getNextTenArtworks(new Object[] {1}).getError());
	}

	@Test
	void testIndexOnlyValidFormat() {
		assertNotNull(ArtworkManager.getNextTenArtworks(new Object[] {0.0}).getData());
	}



	@Test
	void testOneArgInvalid() {
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString()));
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {50.0});
		assertTrue(((ArrayList) request.getData()).isEmpty());
	}

	@Test
	void testTwoArgInvalid() {
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString()));
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {50.0, 0.0});
		assertTrue(((ArrayList) request.getData()).isEmpty());
	}

	@Test
	void testThreeArgInvalidBounds() {
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString()));
		TheArtistsDreamServer.USERS.add(new User(0, "email", "user", "user", new byte[0]));
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {50.0, 0.0, true});
		assertTrue(((ArrayList) request.getData()).isEmpty());
	}

	@Test
	void testThreeArgWithFollowers() {
		TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 1, new ArrayList<>(), 0, LocalDate.now().toString()));
		User user = new User(0, "email", "user", "user", new byte[0]);
		user.addFollowing(1);
		TheArtistsDreamServer.USERS.add(user);
		TheArtistsDreamServer.USERS.add(new User(1, "email2", "user2", "user2", new byte[0]));
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {1.0, 0.0, true});
		assertTrue(((List) request.getData()).isEmpty());
	}

	@Test
	void testThreeArgInvalidBoolean() {
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {1.0, 0.0, "true"});
		assertNotNull(request.getError());
	}

	@Test
	void testThreeArgMoreThanTen() {
		for (int i = 0; i < 10; i++) {
			TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test" + i, 1, new ArrayList<>(), i, LocalDate.now().toString()));
		}
		User user = new User(0, "email", "user", "user", new byte[0]);
		user.addFollowing(1);
		TheArtistsDreamServer.USERS.add(user);
		TheArtistsDreamServer.USERS.add(new User(1, "email2", "user2", "user2", new byte[0]));
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {0.0, 0.0, true});
		assertEquals(10, ((List) request.getData()).size());
	}

	@Test
	void testTwoArgMoreThanTen() {
		for (int i = 0; i < 10; i++) {
			TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test" + i, 0, new ArrayList<>(), i, LocalDate.now().toString()));
		}
		User user = new User(0, "email", "user", "user", new byte[0]);
		TheArtistsDreamServer.USERS.add(user);
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {0.0, 0.0});
		assertEquals(10, ((List) request.getData()).size());
	}

	@Test
	void testOneArgMoreThanTen() {
		for (int i = 0; i < 10; i++) {
			TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test" + i, 0, new ArrayList<>(), i, LocalDate.now().toString()));
		}
		User user = new User(0, "email", "user", "user", new byte[0]);
		TheArtistsDreamServer.USERS.add(user);
		Request request = ArtworkManager.getNextTenArtworks(new Object[] {0.0});
		assertEquals(10, ((List) request.getData()).size());
	}

}
