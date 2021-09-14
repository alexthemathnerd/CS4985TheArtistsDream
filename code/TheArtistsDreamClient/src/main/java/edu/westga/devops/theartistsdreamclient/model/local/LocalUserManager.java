package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.utils.UI;

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
			if (username.equals(currentUser.getUsername())
					&& password.equals(currentUser.getPassword())) {
				return true;
			}
		}
		return false;
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

	public User getUser(String username, String password) {
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
	public boolean addUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException(UI.ErrorMessages.USER_NULL);
		}
		if (this.checkForUser(user.getUserId())) {
			throw new IllegalArgumentException(UI.GuiMessages.USER_EXISTS);
		}
		return this.users.add(user);
	}

	@Override
	public boolean checkForUser(int id) {
		if (id < 0) {
			throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
		}
		for (User currentUser : this.users) {
			if (id == currentUser.getUserId()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the amount of users in the manager
	 * 
	 * @return the amount of users in the manager
	 */
	public int size() {
		return this.users.size();
	}



	@Override
	public Iterator<User> iterator() {
		return this.users.iterator();
	}
	
	public void loadLocalUsers() {
		this.users.add(new LocalUser(0, "jechols5@my.westga.edu","jamiaechols1","JamiaEchols1"));
		this.users.add(new LocalUser(1,"ajoseph7@my.westga.edu","AznellaJoseph","AznellaJoseph1"));
		this.users.add(new LocalUser(2,"aschmid3@my.westga.edu", "alexthemathnerd", "AlexSchmidt1"));
		this.users.add(new LocalUser(3,"jcorely@westga.edu","jcorely1","JonCorely1"));
		this.users.add(new LocalUser(4, "randomArtist@gmail.com","randomArtist5","RandomArtist1"));
	}
}
