package edu.westga.devops.theartistsdreamclient.tests.model.local.localusermanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for LocalUserManager method getUser
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetUser {

	@Test
	void testNegativeId() {
		LocalUserManager testManager = new LocalUserManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.getUser(-1));
	}

	@Test
	void testUserDoesNotExist() {
		LocalUserManager testManager = new LocalUserManager();
		testManager.addUser("test", "test", "test");
		testManager.addUser("test2", "test2", "test2");
		assertNull(testManager.getUser(4));
	}

	@Test
	void testUserExists() {
		LocalUserManager testManager = new LocalUserManager();
		testManager.addUser("test", "test", "test");
		testManager.addUser("test2", "test2", "test2");
		assertNotNull(testManager.getUser(1));
	}

}
