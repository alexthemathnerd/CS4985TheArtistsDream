package edu.westga.devops.theartistsdreamserver.tests.model.tag;

import edu.westga.devops.theartistsdreamserver.model.Tag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit Test Case for Tag Overriden Method compareTo
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestCompareTo {

	@Test
	void testNullTag() {
		Tag testTag = new Tag(1, "test");
		assertThrows(NullPointerException.class, () -> testTag.compareTo(null));
	}

	@Test
	void testGreaterThan() {
		Tag testTag = new Tag(1, "test");
		Tag testTag2 = new Tag(2, "test2");
		testTag2.incrementUseCount();
		testTag2.incrementUseCount();
		assertEquals(2, testTag.compareTo(testTag2));
	}

	@Test
	void testLessThan() {
                Tag testTag = new Tag(1, "test");
                Tag testTag2 = new Tag(2, "test2");
                testTag2.incrementUseCount();
                testTag2.incrementUseCount();
		assertEquals(-2, testTag2.compareTo(testTag));
	}

	@Test
	void testEqual() {
                Tag testTag = new Tag(1, "test");
                Tag testTag2 = new Tag(2, "test");
		assertEquals(0, testTag.compareTo(testTag2));
	}

}
