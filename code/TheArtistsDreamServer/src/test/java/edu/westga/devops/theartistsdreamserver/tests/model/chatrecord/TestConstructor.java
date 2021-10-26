package edu.westga.devops.theartistsdreamserver.tests.model.chatrecord;

import edu.westga.devops.theartistsdreamserver.model.ChatRecord;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for ChatRecord Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testCreation() {
		ChatRecord testChatRecord = new ChatRecord(0, "hello");
		assertAll(() -> assertEquals(0, testChatRecord.getUserId()), () -> assertEquals("hello", testChatRecord.getMessage()));
	}

}
