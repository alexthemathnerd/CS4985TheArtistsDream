package edu.westga.devops.theartistsdreamclient.tests.viewmodel.directmessageviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.DirectMessageViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests DirectMessageViewModel::new
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see DirectMessageViewModel
 */
public class TestConstructor {

    @Test
    void testValidConstructor() {
        DirectMessageViewModel test = new DirectMessageViewModel(null, null);
        assertAll(() -> {
            assertNull(test.chatRecordProperty().get());
            assertEquals("", test.messageStringProperty().get());
        });
    }

}
