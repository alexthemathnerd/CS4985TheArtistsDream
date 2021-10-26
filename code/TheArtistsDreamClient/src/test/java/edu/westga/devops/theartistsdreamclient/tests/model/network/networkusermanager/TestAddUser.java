package edu.westga.devops.theartistsdreamclient.tests.model.network.networkusermanager;

import edu.westga.devops.theartistsdreamclient.model.network.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestAddUser {

    @Mock
    private Communicator communicator;

    @Test
    void testOnResult() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>(null, 0));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        int result = testManager.addUser("", "", "");
        assertEquals(0, result);
    }

    @Test
    void testOnError() {
        Mockito.when(communicator.request(Mockito.any(Request.class), Mockito.any())).thenReturn(new Response<>("error", null));
        NetworkUserManager testManager = new NetworkUserManager(communicator);
        int result = testManager.addUser("", "", "");
        assertEquals(-1, result);
    }

}
