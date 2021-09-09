package edu.westga.devops.theartistsdreamclient.model;
/**
 *  The abstract user  class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public abstract class User {
    private static User user = null;

	public static User getUser() {
		return User.user;
	}

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract int getUserId();
}
