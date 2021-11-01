package edu.westga.devops.theartistsdreamclient.tests.viewmodel.headerviewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.HeaderViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Tests HeaderViewModel::getArtwork
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see HeaderViewModel
 */
@ExtendWith(MockitoExtension.class)
public class TestGetArtwork {

    @Mock
    private ArtworkManager artworkManager;

    @Test
    void testSuccessfulCall() {
        ArtworkManager.setArtworkManager(this.artworkManager);
        HeaderViewModel test = new HeaderViewModel();
        test.getArtwork("");
        Mockito.verify(this.artworkManager).retrieveSearchedArtwork("");
    }

}
