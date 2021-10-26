package edu.westga.devops.theartistsdreamclient.tests.model.chatrecord;

import edu.westga.devops.theartistsdreamclient.model.ChatRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConstructor {

    @Test
    void testValidChatRecord() {
        ChatRecord result = new ChatRecord(0, "");
        assertAll(() -> {
            assertEquals(0, result.getUserId());
            assertEquals("", result.getMessage());
        });
    }

}
