package edu.westga.devops.theartistsdreamclient.tests.viewmodel.addartpopupviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.AddArtPopupViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests AddArtPopupViewModel::new
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see AddArtPopupViewModel
 */
public class TestConstructor {

    @Test
    void testValidConstructor() {
        AddArtPopupViewModel result = new AddArtPopupViewModel();
        assertAll(() -> {
            assertNotNull(result.imageProperty());
            assertNull(result.imageProperty().get());
            assertNotNull(result.tagsProperty());
            assertEquals("", result.tagsProperty().get());
            assertNotNull(result.titleProperty());
            assertEquals("", result.titleProperty().get());
        });
    }

}
