package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.*;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * The LocalUserManager class manages the users that have been loaded from the
 * database
 * 
 * @author Jamia Echols
 * @version Fall 2021
 *
 */
public class LocalUserManager<E> extends UserManager<E> {

	private ArrayList<LocalUser> users;

	/**
	 * Instantiates a new LocalUserManager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public LocalUserManager() {
		this.users = new ArrayList<LocalUser>();
	}

	@Override
	public boolean verifyCredentials(String username, String password) {
		for (LocalUser currentUser : this.users) {
			if (username.equals(currentUser.getUserName())
					&& password.equals(currentUser.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public LocalUser getUser(String username, String password) {
		for (LocalUser currentUser : this.users) {
			if (username.equals(currentUser.getUserName())
					&& password.equals(currentUser.getPassword())) {
				return currentUser;
			}
		}
		return null;
	}

	@Override
	public boolean addUser(LocalUser user) {
		if (user != null) {
			this.users.add(user);
		}
		return false;

	}

	@Override
	public boolean checkForUser(String username) {
		for (LocalUser currentUser : this.users) {
			if (username.equals(currentUser.getUserName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateUser(LocalUser username) {
		return false;
	}
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public ArrayList<LocalUser> getUsers() {
		return this.users;
	}

	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) this.users.iterator();
	}
	
}
