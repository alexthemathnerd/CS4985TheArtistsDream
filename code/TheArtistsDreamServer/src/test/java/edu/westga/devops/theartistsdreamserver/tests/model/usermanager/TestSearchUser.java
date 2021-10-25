package edu.westga.devops.theartistsdreamserver.tests.model.usermanager;

import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Junit test class for the method searchuser in the User manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestSearchUser {
    @Test
    void TestInvalidArgument() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{null};
		assertNotNull(UserManager.searchForUser(param).getData());
    }
}
