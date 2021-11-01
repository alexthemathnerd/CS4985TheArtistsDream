package edu.westga.devops.theartistsdreamserver.tests.model.tag;

import edu.westga.devops.theartistsdreamserver.model.Tag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for Tag Constructor
 * 
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

	@Test
	void testNegativeId() {
		assertThrows(IllegalArgumentException.class, () -> new Tag(-1, "test"));
	}

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> new Tag(1, null));
	}

	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> new Tag(1, ""));
	}

	@Test
	void testValidParameters() {
		Tag testTag = new Tag(1, "TEST");
		assertAll(() -> assertEquals(1, testTag.getId()), () -> assertEquals("test", testTag.getName()), () -> assertEquals(1, testTag.getUseCount()));
	}
}
