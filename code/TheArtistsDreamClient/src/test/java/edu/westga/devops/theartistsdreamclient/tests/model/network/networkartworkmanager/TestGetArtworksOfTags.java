package edu.westga.devops.theartistsdreamclient.tests.model.network.networkartworkmanager;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestGetArtworksOfTags {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        ArrayList<Artwork> expected = new ArrayList<>();
        expected.add(new Artwork(new byte[0], "test", 1, new ArrayList<>(), 0, "2020-10-20"));
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, expected));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        List<Artwork> result = testManager.getArtworksOfTags(new ArrayList<>());
        assertAll(() -> {
            assertFalse(result.isEmpty());
            assertEquals(expected, result);
        });
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkArtworkManager testManager = new NetworkArtworkManager(communicator);
        List<Artwork> result = testManager.getArtworksOfTags(new ArrayList<>());
        assertTrue(result.isEmpty());
    }

}
