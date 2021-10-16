package edu.westga.devops.theartistsdreamclient.tests.viewmodel.filterpopupviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.FilterPopupViewModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit Test Case for FilterPopupViewModel
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestConstructor {

	@Test
	void testPropertyCreations() {
		FilterPopupViewModel testViewModel = new FilterPopupViewModel();

		assertAll(() -> assertEquals("", testViewModel.searchStringProperty().get()), () -> assertNotNull(testViewModel.searchTagsListProperty()), () -> assertNotNull(testViewModel.addedTagsSetProperty()));
	}

}
