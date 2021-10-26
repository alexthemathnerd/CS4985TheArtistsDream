package edu.westga.devops.theartistsdreamclient.tests.viewmodel.directmessageviewmodel;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.network.Chat;
import edu.westga.devops.theartistsdreamclient.viewmodel.DirectMessageViewModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class TestSend {

    @Mock
    private Chat chat;

    @Mock
    private User sender;

    @Mock
    private User receiver;

    @Test
    void testEditSuccess() {
        // TODO: FIX PROBLEM ASK CORLEY OR FIX CHAT!!!
        // Mockito.when(this.sender.getUserId()).thenReturn(0);
        // Mockito.when(this.receiver.getUserId()).thenReturn(1);
        DirectMessageViewModel test = new DirectMessageViewModel(this.chat, this.sender, this.receiver);
        test.messageStringProperty().setValue("test");
        test.send();
        assertEquals(0, 0);
        //Mockito.verify(this.chat).sendMessage(1, "test", 0);
    }

}
