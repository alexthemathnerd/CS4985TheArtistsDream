package edu.westga.devops.theartistsdreamclient.tests.viewmodel.artworkspaneviewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Tests ArtworksPaneViewModel::viewInitialArtworks
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see ArtworksPaneViewModel
 */
@ExtendWith(MockitoExtension.class)
public class TestViewInitialArtworks {

    @Mock
    private ArtworkManager artworkManager;

    @Test
    void testViewInitialOnRecommendedPage() {
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworksPaneViewModel test = new ArtworksPaneViewModel();
        test.userIdProperty().setValue(-1);
        test.viewInitialArtworks();
        Mockito.verify(artworkManager).getFirstFiftyArtworks();
    }

    @Test
    void testViewInitialOnFollowingPage() {
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworksPaneViewModel test = new ArtworksPaneViewModel();
        test.userIdProperty().setValue(0);
        test.onFollowingPageProperty().set(true);
        test.viewInitialArtworks();
        Mockito.verify(artworkManager).getFirstFiftyArtworks(true);
    }

    @Test
    void testViewInitialOnPortfolioPage() {
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworksPaneViewModel test = new ArtworksPaneViewModel();
        test.userIdProperty().setValue(0);
        test.onFollowingPageProperty().set(false);
        test.viewInitialArtworks();
        Mockito.verify(artworkManager).getFirstFiftyArtworks(0);
    }

}
