package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;
import java.util.*;

public class LocalUserManager extends UserManager {

	private List<User> users;

	public LocalUserManager() {
		this.users = new ArrayList<User>();
	}

	@Override
	public User getUser(int userId) {
		if (userId < 0) {
			throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
		}
		for (User currentUser : this.users) {
			if (userId == currentUser.getUserId()) {
				return currentUser;
			}
		}
		return null;
	}

	@Override
	public User findUser(String username, String password) {
		if (username == null) {
			throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_NULL);
		}
		if (password == null) {
			throw new IllegalArgumentException(UI.ErrorMessages.PASSWORD_NULL);
		}
		if (username.isEmpty()) {
			throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_EMPTY);
		}
		if (password.isEmpty()) {
			throw new IllegalArgumentException(UI.ErrorMessages.PASSWORD_EMPTY);
		}
		for (User currentUser : this.users) {
			if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
				return currentUser;
			}
		}
		return null;
	}

	@Override
	public int addUser(String username, String password, String email) {
		for (User user : this.users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return -1;
			}
		}
		this.users.add(new User(this.size(), email, username, password));
		return this.size() - 1;
	}
	
	@Override
	public ArrayList<User> searchForUsers(String searchTerm) {
		ArrayList<User> searchedUsers = new ArrayList<User>();
		for (User user : this.users) {
			if (user.getUsername().contains(searchTerm)) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}

	public int size() {
		return this.users.size();
	}

}
