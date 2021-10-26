package edu.westga.devops.theartistsdreamclient.tests.viewmodel.artworkpopupviewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworkPopupViewModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConstructor {

    @Test
    void testValidConstructor() {
        Artwork artwork = new Artwork(new byte[0], "test", 0, new ArrayList<>(), 0, LocalDate.now().toString());
        ArtworkPopupViewModel test = new ArtworkPopupViewModel(artwork);
        assertAll(() -> {
           assertEquals("test",test.titleProperty().get());
           assertEquals(artwork, test.getArtwork());
        });
    }

}
