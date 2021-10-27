package edu.westga.devops.theartistsdreamclient.tests.model.user;

import edu.westga.devops.theartistsdreamclient.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * JUnit Test Case for User Method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetUser {

    @BeforeEach
    void init() {
        User.setUser(null);
    }

    @Test
    void testNull() {
        assertNull(User.getUser());
    }

    @Test
    void testNotNull() {
        User.setUser(new User(1, "test", "test", "test", new byte[0]));
        assertNotNull(User.getUser());
    }
}
