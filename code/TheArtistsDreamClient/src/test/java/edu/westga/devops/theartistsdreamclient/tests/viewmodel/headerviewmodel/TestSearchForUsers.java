package edu.westga.devops.theartistsdreamclient.tests.viewmodel.headerviewmodel;

import edu.westga.devops.theartistsdreamclient.viewmodel.HeaderViewModel;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit Test Case for HeaderViewModel Method searchForUsers
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class TestSearchForUsers {

	@Test
	void testEmptyManager() {
		UserManager.setUserManager(new LocalUserManager());
		HeaderViewModel testViewModel = new HeaderViewModel();

		assertEquals(0, testViewModel.searchForUsers("student").size());
	}

	@Test
	void testSearchTermMatchesNone() {
		HeaderViewModel testViewModel = new HeaderViewModel();
		UserManager.setUserManager(new LocalUserManager());

		UserManager.getUserManager().addUser("student", "student123", "student@my.westga.edu");
		UserManager.getUserManager().addUser("student2", "student456", "devopsstu@my.westga.edu");
		UserManager.getUserManager().addUser("student3", "devopsstudent", "studevops@my.westga.edu");

		assertEquals(0, testViewModel.searchForUsers("devops").size());
	}

	@Test
	void testSearchTermMatchesOne() {

                HeaderViewModel testViewModel = new HeaderViewModel();
                UserManager.setUserManager(new LocalUserManager());

                UserManager.getUserManager().addUser("student", "student123", "student@my.westga.edu");
                UserManager.getUserManager().addUser("student2", "student456", "devopsstu@my.westga.edu");
                UserManager.getUserManager().addUser("student3", "devopsstudent", "studevops@my.westga.edu");

                assertEquals(1, testViewModel.searchForUsers("student3").size());
	}

	@Test
	void testSearchTermMatchesAll() {
                HeaderViewModel testViewModel = new HeaderViewModel();
                UserManager.setUserManager(new LocalUserManager());

                UserManager.getUserManager().addUser("student", "student123", "student@my.westga.edu");
                UserManager.getUserManager().addUser("student2", "student456", "devopsstu@my.westga.edu");
                UserManager.getUserManager().addUser("student3", "devopsstudent", "studevops@my.westga.edu");

                assertEquals(3, testViewModel.searchForUsers("student").size());
	}
}
