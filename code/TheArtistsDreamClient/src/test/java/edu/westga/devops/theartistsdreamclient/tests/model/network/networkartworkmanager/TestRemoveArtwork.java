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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests NetworkArtworkManager::removeArtwork
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see NetworkArtworkManager
 */
@ExtendWith(MockitoExtension.class)
public class TestRemoveArtwork {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResultSuccess() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, true));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertTrue(testManager.removeArtwork(0));
    }

    @Test
    void testOnResultFail() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, false));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertFalse(testManager.removeArtwork(0));
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertFalse(testManager.removeArtwork(0));
    }

}
