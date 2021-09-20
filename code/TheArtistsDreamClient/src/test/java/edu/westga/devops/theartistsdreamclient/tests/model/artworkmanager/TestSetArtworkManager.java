package edu.westga.devops.theartistsdreamclient.tests.model.artworkmanager;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for ArtworkManager Method setArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSetArtworkManager {

        @Test
        void setToNewUserManager() {
                ArtworkManager.setArtworkManager(new LocalArtworkManager());
                assertNotNull(ArtworkManager.getArtworkManager());
        }

        @Test
        void setToNull() {
                assertThrows(IllegalArgumentException.class, () -> ArtworkManager.setArtworkManager(null));
        }

}

