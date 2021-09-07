package edu.westga.devops.theartistsdreamclient.viewmodel;

import javafx.beans.property.*;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUserManager;

/**
 * The Login View Model
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class LoginViewModel {
    private StringProperty usernameStringProperty;
    private StringProperty passwordStringProperty;
    private StringProperty emailStringProperty;
    private LocalUserManager userManager;


    public LoginViewModel() {
        this.usernameStringProperty = new SimpleStringProperty("");
        this.passwordStringProperty = new SimpleStringProperty("");
        this.emailStringProperty = new SimpleStringProperty("");
        this.userManager = new LocalUserManager();
    }

    public StringProperty usernameStringProperty() {
        return this.usernameStringProperty;
    }

    public StringProperty passwordStringProperty() {
        return this.passwordStringProperty;
    }

    public StringProperty emailStringProperty() {
        return this.emailStringProperty;
    }

    public LocalUserManager getUserManager() {
        return this.userManager;
    }

	public boolean checkIfUserAlreadyExists(User user) {
		if (this.userManager.getUsers().contains(user)) {
			return true;
		}
		return false;
    }

    public void addUser() {
        User newUser = new User(this.emailStringProperty.get(), this.usernameStringProperty.get(), this.passwordStringProperty.get());
        if (!this.checkIfUserAlreadyExists(newUser)) {
            this.userManager.addUser(newUser);
        }
    }

    public User getUser() {
        return this.userManager.getUser(this.usernameStringProperty.get(), this.passwordStringProperty.get());
    }
}
