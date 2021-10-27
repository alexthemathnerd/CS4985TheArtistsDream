package edu.westga.devops.theartistsdreamclient.tests.model.network.networkusermanager;

import edu.westga.devops.theartistsdreamclient.model.network.Communicator;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkUserManager;
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
 * Tests NetworkUserManager::getFollowingIds
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see NetworkUserManager
 */
@ExtendWith(MockitoExtension.class)
public class TestGetFollowingIds {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, expected));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        List<Integer> result = testManager.getFollowingIds(0);
        assertAll(() -> {
            assertFalse(result.isEmpty());
            assertEquals(expected, result);
        });
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        List<Integer> result = testManager.getFollowingIds(0);
        assertTrue(result.isEmpty());
    }
}
