package edu.westga.devops.theartistsdreamclient.tests.viewmodel.artworkspaneviewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests ArtworksPaneViewModel::viewMoreArtworks
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see ArtworksPaneViewModel
 */
@ExtendWith(MockitoExtension.class)
public class TestViewMoreArtworks {

    @Mock
    private ArtworkManager artworkManager;

    @Test
    void testViewMoreOnRecommendedPage() {
        Artwork artwork = new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString());
        Mockito.when(artworkManager.getNextTenArtworks(0)).thenReturn(List.of(artwork));
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworksPaneViewModel test = new ArtworksPaneViewModel();
        test.userIdProperty().setValue(-1);
        test.viewMoreArtworks();
        Mockito.verify(artworkManager).getNextTenArtworks(0);
        assertEquals(1, test.indexProperty().get());
    }

    @Test
    void testViewMoreOnPortfolioPage() {
        Artwork artwork = new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString());
        Mockito.when(artworkManager.getNextTenArtworks(0, 0)).thenReturn(List.of(artwork));
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworksPaneViewModel test = new ArtworksPaneViewModel();
        test.userIdProperty().setValue(0);
        test.viewMoreArtworks();
        Mockito.verify(artworkManager).getNextTenArtworks(0, 0);
        assertEquals(1, test.indexProperty().get());
    }

}
