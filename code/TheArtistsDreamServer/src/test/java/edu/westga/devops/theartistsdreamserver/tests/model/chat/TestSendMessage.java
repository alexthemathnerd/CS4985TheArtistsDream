package edu.westga.devops.theartistsdreamserver.tests.model.chat;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Chat;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.model.Request;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for Chat Method sendMessage
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSendMessage {

	@Test
	void testInvalidFormat() {
		assertEquals(UI.ErrorMessages.INVALID_FORMAT, Chat.sendMessage(new Object[] {1, 1, 1}).getError());
	}

	@Test
	void testValidFormat() {
		TheArtistsDreamServer.USERS.clear();
		UserManager.addUser(new Object[] {"student", "student123", "student@my.westga.edu"});
		UserManager.addUser(new Object[] {"test", "test123", "test@my.westga.edu"});
		Request testRequest = Chat.sendMessage(new Object[] {1.0, "hello", 0.0});
		assertAll(() -> assertNotNull(testRequest.getData()), () -> assertNull(testRequest.getError()));
	}

	@Test
	void testReceiver() {
		TheArtistsDreamServer.USERS.clear();
                UserManager.addUser(new Object[] {"student", "student123", "student@my.westga.edu"});
                UserManager.addUser(new Object[] {"test", "test123", "test@my.westga.edu"});
                Request testRequest = Chat.sendMessage(new Object[] {0.0, "hello", 1.0});
                assertAll(() -> assertNotNull(testRequest.getData()), () -> assertNull(testRequest.getError()));
	}
}	
