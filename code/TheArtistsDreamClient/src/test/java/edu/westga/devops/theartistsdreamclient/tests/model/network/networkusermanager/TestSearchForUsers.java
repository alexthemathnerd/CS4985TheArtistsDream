package edu.westga.devops.theartistsdreamclient.tests.model.network.networkusermanager;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.network.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestSearchForUsers {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        List<User> expected = new ArrayList<>();
        expected.add(new User(0, "test@test.com", "test", "test", new byte[0]));
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, expected));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        List<User> result = testManager.searchForUsers("");
        assertAll(() -> {
            assertFalse(result.isEmpty());
            assertEquals(expected, result);
        });
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        List<User> result = testManager.searchForUsers("");
        assertTrue(result.isEmpty());
    }

}
