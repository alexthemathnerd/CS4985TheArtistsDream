package edu.westga.devops.theartistsdreamclient.tests.model.local.localtagmanager;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for LocalTagManager Constructor
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class TestConstructor {

	@Test
	void testListCreation() {
		LocalTagManager testManager = new LocalTagManager();
		assertNotNull(testManager.iterator());
	}
}
