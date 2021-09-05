package edu.westga.devops.theartistsdreamclient.model;
/**
 * The userManager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public abstract class UserManager {
    private static UserManager userManager = null;

	/**
	 * Gets the UserManager
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the user manager
	 */
	public static UserManager getUserManager() {
		return UserManager.userManager;
	}

	/**
	 * Sets the UserManager
	 * 
	 * @precondition userManager != null
	 * @postcondition getUserManager() == userManager
	 * @param userManager the new user manager
	 */
	public static void setUserManager(UserManager userManager) {
		UserManager.userManager = userManager;
	}

	/**
	 * Verifies the credentials of the user logging in
	 * 
	 * @precondition !username.isEmpty() && username != null && !password.isEmpty()
	 *               && password != null
	 * @postcondition none
	 * 
	 * @param username the username of the user logging in
	 * @param password the password of the user logging in
	 * @return true if the credentials are verified, false otherwise
	 */
	public abstract boolean verifyCredentials(String username, String password);

	/**
	 * Gets the user with the given username and password
	 * 
	 * @precondition !username.isEmpty() && username != null && !password.isEmpty()
	 *               && password != null
	 * @postcondition none
	 * 
	 * @param username the username of the user to get
	 * @param password the password of the user to get
	 * @return the user with the given username and password
	 */
	public abstract User getUser(String username, String password);

	/**
	 * Adds a user with the given username and password.
	 *
	 * @param user the user to add
	 * @return true, if successful
	 * @precondition !username.isEmpty() && username != null && !password.isEmpty()
	 *               && password != null
	 * @postcondition none
	 */
	public abstract boolean addUser(User user);

	/**
	 * Checks if a user has the given username
	 * 
	 * @precondition !username.isEmpty() && username != null
	 * @postcondition none
	 * @param username the username to look for
	 * @return true if the user with the given username exists, false otherwise
	 */
	public abstract boolean checkForUser(String username);

	/**
	 * Updates the users information
	 * 
	 * @precondition user != null
	 * @postcondition none
	 * @param user the user to update
	 * @return true if the user has been updated, false otherwise
	 */
	public abstract boolean updateUser(User user);
}
