package edu.westga.devops.theartistsdreamserver.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Artwork;
import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for ArtworkManager method getFirstFiftyArtworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestGetFirstFiftyArtworks {

	@Test
	void testIdOnlyInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getFirstFiftyArtworks(new Object[]{1}).getError());
	}

        @Test
        void testIdWithFollowingInvalidFormat() {
                assertEquals(UI.ErrorMessages.INVALID_FORMAT, ArtworkManager.getFirstFiftyArtworks(new Object[]{1, "true"}).getError());
        }

	@Test
	void testNoDataSizeLessThanFifty() {
		TheArtistsDreamServer.ARTWORKS.clear();
		assertNotNull(ArtworkManager.getFirstFiftyArtworks(new Object[] {}).getData());
	}

	@Test
	void testNoDataSizeEqualToFifty() {
		TheArtistsDreamServer.ARTWORKS.clear();
		for (int i = 0; i < 50; i++) {
			TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", i, new ArrayList<Integer>(), i, "2021-10-10"));
		}
		assertEquals(50, ((List<Artwork>)ArtworkManager.getFirstFiftyArtworks(new Object[] {}).getData()).size());
	}

	@Test
	void testIdOnlySizeLessThanFifty() {
		TheArtistsDreamServer.ARTWORKS.clear();
		for (int i = 0; i < 50; i++) {
                        TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", i, new ArrayList<Integer>(), i, "2021-10-10"));
                }
		assertEquals(1, ((List<Artwork>)ArtworkManager.getFirstFiftyArtworks(new Object[] {1.0}).getData()).size());
	}

        @Test
        void testIdOnlySizeEqualToFifty() {
		TheArtistsDreamServer.ARTWORKS.clear();
                for (int i = 0; i < 50; i++) {
                        TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), i, "2021-10-10"));
                }
                assertEquals(50, ((List<Artwork>)ArtworkManager.getFirstFiftyArtworks(new Object[] {1.0}).getData()).size());
        }

	        @Test
        void testIdAndFollowingSizeLessThanFifty() {
                TheArtistsDreamServer.ARTWORKS.clear();
                for (int i = 0; i < 50; i++) {
                        TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", i, new ArrayList<Integer>(), i, "2021-10-10"));
                }
		UserManager.addUser(new Object[] {"test", "test123", "test@my.westga.edu"});
                UserManager.addUser(new Object[] {"test2", "test456", "test2@my.westga.edu"});
                User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
                testUser.addFollowing(1);

                assertEquals(1, ((List<Artwork>)ArtworkManager.getFirstFiftyArtworks(new Object[] {0.0, true}).getData()).size());
        }


	@Test
	void testIdAndFollowingSizeEqualToFifty() {
                TheArtistsDreamServer.ARTWORKS.clear();
                for (int i = 0; i < 50; i++) {
                        TheArtistsDreamServer.ARTWORKS.add(new Artwork(new byte[0], "test", 1, new ArrayList<Integer>(), i, "2021-10-10"));
                }
		UserManager.addUser(new Object[] {"test", "test123", "test@my.westga.edu"});
		UserManager.addUser(new Object[] {"test2", "test456", "test2@my.westga.edu"});
		User testUser = (User) UserManager.getUser(new Object[] {0.0}).getData();
		testUser.addFollowing(1);
                assertEquals(50, ((List<Artwork>)ArtworkManager.getFirstFiftyArtworks(new Object[] {0.0,true}).getData()).size());
	}

}
