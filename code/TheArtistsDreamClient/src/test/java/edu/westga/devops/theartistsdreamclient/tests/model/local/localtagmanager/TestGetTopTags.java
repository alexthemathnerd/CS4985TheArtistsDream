package edu.westga.devops.theartistsdreamclient.tests.model.local.localtagmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for LocalTagManager method getTopTenTags
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestGetTopTags {


	@Test
	void testNegativeAmount() {
		LocalTagManager testManager = new LocalTagManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.getTopTags(-1, "test"));
	}

	@Test
	void testNullContent() {
		LocalTagManager testManager = new LocalTagManager();
		assertThrows(IllegalArgumentException.class, () -> testManager.getTopTags(1, null));
	}

	@Test
	void testEmptyContent() {
		LocalTagManager testManager = new LocalTagManager();
		assertEquals(0, testManager.getTopTags(1, "").size());
	}

	@Test
	void testSizeLessThanAmount() {
		LocalTagManager testManager = new LocalTagManager();
		testManager.addTag("test");
		testManager.addTag("test 2");

		assertEquals(2, testManager.getTopTags(4, "test").size());
	}

	@Test
	void testSizeMoreThanAmount() {
		LocalTagManager testManager = new LocalTagManager();
		testManager.addTag("test");
		testManager.addTag("test2");
		testManager.addTag("test3");

		assertEquals(2, testManager.getTopTags(2, "test").size());
	}
}
