package edu.westga.devops.theartistsdreamclient.viewmodel;

import javafx.beans.property.*;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;
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
    private StringProperty confirmPasswordStringProperty;
    private StringProperty emailStringProperty;
    private StringProperty errorLabelStringProperty;
    private LocalUserManager userManager;


    public LoginViewModel() {
        this.usernameStringProperty = new SimpleStringProperty();
        this.passwordStringProperty = new SimpleStringProperty();
        this.confirmPasswordStringProperty = new SimpleStringProperty();
        this.emailStringProperty = new SimpleStringProperty();
        this.errorLabelStringProperty = new SimpleStringProperty();
        this.userManager = new LocalUserManager();
    }

    public StringProperty errorLabelStringProperty() {
        return this.errorLabelStringProperty;
    }

    public StringProperty usernameStringProperty() {
        return this.usernameStringProperty;
    }

    public StringProperty passwordStringProperty() {
        return this.passwordStringProperty;
    }

    public StringProperty confirmPasswordStringProperty() {
        return this.confirmPasswordStringProperty;
    }

    public StringProperty emailStringProperty() {
        return this.emailStringProperty;
    }

    public LocalUserManager getUserManager() {
        return this.userManager;
    }

	public boolean checkIfUserAlreadyExists(LocalUser user) {
		return this.userManager.getUsers().contains(user);
    }

    public void addUser() {
        LocalUser newUser = new LocalUser(this.emailStringProperty.get(), this.usernameStringProperty.get(), this.passwordStringProperty.get());
        if (!this.checkIfUserAlreadyExists(newUser)) {
            this.userManager.addUser(newUser);
        } else {
            this.errorLabelStringProperty.set("User already exisits");
        }
    }

    public LocalUser getUser() {
        return this.userManager.getUser(this.usernameStringProperty.get(), this.passwordStringProperty.get());
    }

    public String validateCreateAccount() {
        if (!this.emailStringProperty.get().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            return "Must enter a valid email.";
        }
        if (this.passwordStringProperty.get().length() < 7) {
            return "Password length must be greater than 7";
        }
        if (!this.passwordStringProperty.get().equals(this.confirmPasswordStringProperty.get())) {
            return "Passwords must match";
        }
        return "";
    }
}
