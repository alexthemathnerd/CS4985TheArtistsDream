package edu.westga.devops.theartistsdreamserver.tests.model.user;

import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.ChatRecord;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for User Method updateChat
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestUpdateChat {

	@Test
	void testUpdate() {
		User testUser = new User(1, "test@my.westga.edu", "test", "test123", new byte[0]);
		testUser.getMessages().put(2, new ArrayList<ChatRecord>(Arrays.asList(new ChatRecord(1, "hello"), new ChatRecord(2, "hi there"))));
		testUser.updateChat(2, new ArrayList<ChatRecord>());
		assertEquals(0, testUser.getChatByUserId(2).size());
	}

}
