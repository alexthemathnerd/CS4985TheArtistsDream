package edu.westga.devops.theartistsdreamclient.tests.model.user;

import edu.westga.devops.theartistsdreamclient.model.User;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestEquals {

    @Test
    void testSameInstance() {
        User user = new User(0, "email", "username", "password", new byte[0]);
        assertTrue(user.equals(user));
    }

    @Test
    void testDiffrentInstanceEqual() {
        User user1 = new User(0, "email", "username", "password", new byte[0]);
        User user2 = new User(0, "email", "username", "password", new byte[0]);
        assertTrue(user1.equals(user2));
    }

    @Test
    void testDiffrentInstanceNotEqual() {
        User user1 = new User(0, "email", "username", "password", new byte[0]);
        User user2 = new User(1, "email", "username", "password", new byte[0]);
        assertFalse(user1.equals(user2));
    }

    @Test
    void testDiffrentType() {
        User user1 = new User(0, "email", "username", "password", new byte[0]);
        assertFalse(user1.equals("hello"));
    }

}
