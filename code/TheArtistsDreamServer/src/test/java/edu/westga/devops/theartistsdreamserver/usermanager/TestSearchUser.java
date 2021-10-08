package edu.westga.devops.theartistsdreamserver.usermanager;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import edu.westga.devops.theartistsdreamserver.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestSearchUser {
    @Test
    void TestInvalidArgument() {
        TheArtistsDreamServer.USERS.clear();
		UserManager testManager = new UserManager();
        Object[] param = new Object[]{null};
		assertNotNull(testManager.searchForUser(param).getData());
    }
}
