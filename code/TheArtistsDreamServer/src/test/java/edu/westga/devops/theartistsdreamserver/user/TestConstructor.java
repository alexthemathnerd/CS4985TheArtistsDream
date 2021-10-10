package edu.westga.devops.theartistsdreamserver.user;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/**
 * Junit test class for the constructor in the User class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestConstructor {
    @Test
    void TestConstructor() {
        InputStream profile = TheArtistsDreamServer.class.getResourceAsStream("assets/default.jpg");
        byte[] image = new byte[0];
        try {
            image = IOUtils.toByteArray(profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User testUser = new User(0,"email@email.com","username","password", image);
        assertAll(
            () -> assertEquals(0, testUser.getUserId()), 
            () -> assertEquals("email@email.com", testUser.getEmail()), 
            () -> assertEquals("username", testUser.getUsername()), 
            () -> assertEquals("password", testUser.getPassword()),
            () -> assertNotNull(testUser.getProfilePic()));
    }
}
