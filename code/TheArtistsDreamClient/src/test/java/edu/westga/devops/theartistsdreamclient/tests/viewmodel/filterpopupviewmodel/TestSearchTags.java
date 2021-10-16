package edu.westga.devops.theartistsdreamclient.tests.viewmodel.filterpopupviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.FilterPopupViewModel;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for FilterPopupViewModel Method searchTags
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSearchTags {

	@Test
	void testEmptyManager() {
		TagManager.setTagManager(new LocalTagManager());
		FilterPopupViewModel testViewModel = new FilterPopupViewModel();

		testViewModel.searchStringProperty().set("devops");
		testViewModel.searchTags(3);
		assertEquals(0, testViewModel.searchTagsListProperty().size());
	}

	@Test
	void testSearchTermMatchesNone() {
		TagManager.setTagManager(new LocalTagManager());
		FilterPopupViewModel testViewModel = new FilterPopupViewModel();

		TagManager.getTagManager().addTag("test1");
		TagManager.getTagManager().addTag("test2");
		TagManager.getTagManager().addTag("test3");

		testViewModel.searchStringProperty().set("devops");
		testViewModel.searchTags(3);
		assertEquals(0, testViewModel.searchTagsListProperty().size());
	}

        @Test
        void testSearchTermMatchesOne() {
                TagManager.setTagManager(new LocalTagManager());
                FilterPopupViewModel testViewModel = new FilterPopupViewModel();

                TagManager.getTagManager().addTag("test1");
                TagManager.getTagManager().addTag("test2");
                TagManager.getTagManager().addTag("test3");

                testViewModel.searchStringProperty().set("test1");
                testViewModel.searchTags(1);
                assertEquals(1, testViewModel.searchTagsListProperty().size());
        }

        @Test
        void testSearchTermMatchesAll() {
                TagManager.setTagManager(new LocalTagManager());
                FilterPopupViewModel testViewModel = new FilterPopupViewModel();

                TagManager.getTagManager().addTag("test1");
                TagManager.getTagManager().addTag("test2");
                TagManager.getTagManager().addTag("test3");

                testViewModel.searchStringProperty().set("test");
                testViewModel.searchTags(3);
                assertEquals(3, testViewModel.searchTagsListProperty().size());
        }

}
