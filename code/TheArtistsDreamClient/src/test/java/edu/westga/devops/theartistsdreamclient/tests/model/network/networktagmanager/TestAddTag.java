package edu.westga.devops.theartistsdreamclient.tests.model.network.networktagmanager;

import edu.westga.devops.theartistsdreamclient.model.network.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests NetworkTagManager::addTag
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see NetworkTagManager
 */
@ExtendWith(MockitoExtension.class)
public class TestAddTag {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, 0.0));
        NetworkTagManager testManager = new NetworkTagManager(communicator);
        int result = testManager.addTag("");
        assertEquals(0, result);
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkTagManager testManager = new NetworkTagManager(communicator);
        int result = testManager.addTag("");
        assertEquals(-1, result);
    }

}
