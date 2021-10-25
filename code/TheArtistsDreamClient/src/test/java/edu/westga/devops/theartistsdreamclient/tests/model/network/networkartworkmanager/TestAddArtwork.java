package edu.westga.devops.theartistsdreamclient.tests.model.network.networkartworkmanager;

import com.google.gson.reflect.TypeToken;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests Add Artwork in NetworkArtworkManager
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see NetworkArtworkManager
 */
@ExtendWith(MockitoExtension.class)
public class TestAddArtwork {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResultSuccess() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, true));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertTrue(testManager.addArtwork(new byte[0], "test", 1, new ArrayList<>(), "2020-10-20"));
    }

    @Test
    void testOnResultFail() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, false));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertFalse(testManager.addArtwork(new byte[0], "test", 1, new ArrayList<>(), "2020-10-20"));
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        assertFalse(testManager.addArtwork(new byte[0], "test", 1, new ArrayList<>(), "2020-10-20"));
    }


}
