package edu.westga.devops.theartistsdreamclient.tests.model.network.networkusermanager;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.network.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TestGetUser {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        User expected = new User(0, "test@test.com","test", "test", new byte[0]);
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, expected));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        User result = testManager.getUser(0);
        assertEquals(expected, result);
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        User result = testManager.getUser(0);
        assertNull(result);
    }

}
