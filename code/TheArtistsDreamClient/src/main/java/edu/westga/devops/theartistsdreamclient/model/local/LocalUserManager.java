package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.*;
import java.util.ArrayList;


/**
 * The LocalUserManager class manages the users that have been loaded from the
 * database
 * 
 * @author Jamia Echols
 * @version Fall 2021
 *
 */
public class LocalUserManager extends UserManager {

	private ArrayList<User> users;

	/**
	 * Instantiates a new LocalUserManager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public LocalUserManager() {
		this.users = new ArrayList<User>();
	}

	@Override
	public boolean verifyCredentials(String username, String password) {
		for (User currentUser : this.users) {
			if (username.equals(currentUser.getUserName())
					&& password.equals(currentUser.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUser(String username, String password) {
		for (User currentUser : this.users) {
			if (username.equals(currentUser.getUserName())
					&& password.equals(currentUser.getPassword())) {
				return currentUser;
			}
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		if (user != null) {
			this.users.add(user);
		}
		return false;
	}

	@Override
	public boolean checkForUser(String username) {
		for (User currentUser : this.users) {
			if (username.equals(currentUser.getUserName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateUser(User username) {
		return false;
	}
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public ArrayList<User> getUsers() {
		return this.users;
	}
	
}
