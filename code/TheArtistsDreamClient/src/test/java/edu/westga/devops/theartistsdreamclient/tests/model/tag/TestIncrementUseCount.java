package edu.westga.devops.theartistsdreamclient.tests.model.tag;

import edu.westga.devops.theartistsdreamclient.model.Tag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for Tag Method incrementUseCount
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestIncrementUseCount {

	@Test
	void testIncrement() {
		Tag testTag = new Tag(1, "test");
		testTag.incrementUseCount();
		testTag.incrementUseCount();
		assertEquals(3, testTag.getUseCount());
	}
}
