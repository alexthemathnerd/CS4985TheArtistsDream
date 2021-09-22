package edu.westga.devops.theartistsdreamclient.tests.model.usermanager;

import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for UserManager Method setUserManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestSetUserManager {

	@Test
	void setToNewUserManager() {
		UserManager.setUserManager(new LocalUserManager());
		assertNotNull(UserManager.getUserManager());
	}

	@Test
	void setToNull() {
		assertThrows(IllegalArgumentException.class, () -> UserManager.setUserManager(null));
	}

}
