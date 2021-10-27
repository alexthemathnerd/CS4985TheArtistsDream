package edu.westga.devops.theartistsdreamclient.tests.model.network.networktagmanager;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkTagManager;
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

/**
 * Tests NetworkTagManager::getTopTags
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see NetworkTagManager
 */
@ExtendWith(MockitoExtension.class)
public class TestGetTopTags {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        List<Tag> expected = new ArrayList<>();
        expected.add(new Tag(0, "test"));
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, expected));
        NetworkTagManager testManager = new NetworkTagManager(communicator);
        List<Tag> result = testManager.getTopTags(0, "");
        assertAll(() -> {
            assertFalse(result.isEmpty());
            assertEquals(expected, result);
        });
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkTagManager testManager = new NetworkTagManager(communicator);
        List<Tag> result = testManager.getTopTags(0, "");
        assertTrue(result.isEmpty());
    }
}
