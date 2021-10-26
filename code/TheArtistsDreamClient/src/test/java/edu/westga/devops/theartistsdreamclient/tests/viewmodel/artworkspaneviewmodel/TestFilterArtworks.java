package edu.westga.devops.theartistsdreamclient.tests.viewmodel.artworkspaneviewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestFilterArtworks {

    @Mock
    private ArtworkManager artworkManager;

    @Test
    void testTagsAdded() {
        Mockito.when(artworkManager.getArtworksOfTags(Mockito.anyList())).thenReturn(new ArrayList<>());
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworksPaneViewModel test = new ArtworksPaneViewModel();
        test.filterArtworks();
        assertTrue(test.artworksProperty().isEmpty());
    }

}
