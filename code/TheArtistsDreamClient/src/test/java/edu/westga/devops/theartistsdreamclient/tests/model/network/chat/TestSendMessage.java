package edu.westga.devops.theartistsdreamclient.tests.model.network.chat;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ChatRecord;
import edu.westga.devops.theartistsdreamclient.model.network.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TestSendMessage {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        ChatRecord expected = new ChatRecord(0, "");
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, expected));
        Chat testManager = new Chat(communicator);
        ChatRecord result = testManager.sendMessage(0, "", 0);
        assertEquals(expected, result);
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        Chat testManager = new Chat(communicator);
        ChatRecord result = testManager.sendMessage(0, "", 0);
        assertNull(result);
    }

}
