package edu.westga.devops.theartistsdreamclient.model;

import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * The UserManager class manages the users that have been loaded from the
 * database
 * 
 * @author Jamia Echols
 * @version Fall 2021
 *
 */
public abstract class UserManager {

	private static UserManager userManager = null;

	/**
	 * Gets the user specified by the id
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the user specified by the id
	 */
	public abstract User getUser(int userId);

	/**
	 * Finds the user specified by the username and password
	 *
	 * @precondition username != null && password != null && !username.isEmpty() && !password.isEmpty()
	 * @postcondition none
	 *
	 * @return the user specified by the username and password
	 */
	public abstract User findUser(String username, String password);

	/**
	 * Adds the user specified by the username, password, and email
	 *
	 * @precondition username != null && password != null && email != null && !username.isEmpty() && !password.isEmpty() && !email.isEmpty()
	 * @postcondition none
	 *
	 * @return the id of the added user or -1 if the username and password are used already
	 */
	public abstract int addUser(String username, String password, String email);
	

    /**
     * Gets the singleton of the user manager
     *
     * @return the singleton of the user manager
     *
     * @precondition none
     * @postcondition none
     */
    public static UserManager getUserManager() {
        return UserManager.userManager;
    }

    /**
     * Sets the userManager singleton
     *
     * @param tagManager the new user manager
     *
     * @preconditon userManager != null
     * @postcondition getUserManager() == userManager 
     */
    public static void setUserManager(UserManager userManager) {
        if (userManager == null) {
            throw new IllegalArgumentException();
        }
        UserManager.userManager = userManager;
    }
}
