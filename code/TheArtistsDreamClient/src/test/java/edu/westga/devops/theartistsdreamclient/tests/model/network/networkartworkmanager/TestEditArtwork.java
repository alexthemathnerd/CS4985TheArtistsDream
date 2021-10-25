package edu.westga.devops.theartistsdreamclient.tests.model.network.networkartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.network.Request;
import edu.westga.devops.theartistsdreamclient.model.network.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestEditArtwork {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResultSuccess() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, true));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertTrue(testManager.editArtwork(0, "test", new ArrayList<>()));
    }

    @Test
    void testOnResultFail() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, false));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertFalse(testManager.editArtwork(0, "test", new ArrayList<>()));
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertFalse(testManager.editArtwork(0, "test", new ArrayList<>()));
    }

}
