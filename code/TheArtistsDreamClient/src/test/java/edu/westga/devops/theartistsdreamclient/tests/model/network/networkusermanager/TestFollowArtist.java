package edu.westga.devops.theartistsdreamclient.tests.model.network.networkusermanager;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkUserManager;
import edu.westga.devops.theartistsdreamclient.model.network.Request;
import edu.westga.devops.theartistsdreamclient.model.network.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestFollowArtist {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResultSuccess() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, true));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        boolean result = testManager.followArtist(0, 0);
        assertTrue(result);
    }

    @Test
    void testOnResultFail() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, false));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        boolean result = testManager.followArtist(0, 0);
        assertFalse(result);
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        boolean result = testManager.followArtist(0, 0);
        assertFalse(result);
    }

}
