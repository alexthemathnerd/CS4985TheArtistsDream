package edu.westga.devops.theartistsdreamclient.tests.viewmodel.artworkpopupviewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworkPopupViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class TestEditArtwork {

    @Mock
    private ArtworkManager artworkManager;

    @Test
    void testEditSuccess() {
        Artwork artwork = new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString());
        ArtworkManager.setArtworkManager(artworkManager);
        ArtworkPopupViewModel test = new ArtworkPopupViewModel(artwork);
        test.titleProperty().setValue("new");
        test.editArtwork();
        Mockito.verify(artworkManager).editArtwork(0, "new", new ArrayList<>());
    }

}
