package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import javafx.beans.property.*;
import edu.westga.devops.theartistsdreamclient.model.*;

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
    private UserManager userManager;


    public LoginViewModel() {
        this.usernameStringProperty = new SimpleStringProperty("");
        this.passwordStringProperty = new SimpleStringProperty("");

        this.confirmPasswordStringProperty = new SimpleStringProperty("");
        this.emailStringProperty = new SimpleStringProperty("");
        this.errorLabelStringProperty = new SimpleStringProperty("");
        this.userManager = new UserManager();
        this.userManager.loadLocalUsers();
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

    public UserManager getUserManager() {
        return this.userManager;
    }

	public boolean checkIfUserAlreadyExists(User user) {
		return this.userManager.checkForUser(user.getUserId());
    }

    public void addUser() {
        User newUser = new User(this.userManager.size(), this.emailStringProperty.get(), this.usernameStringProperty.get(), this.passwordStringProperty.get());
        if (!this.checkIfUserAlreadyExists(newUser)) {
            this.userManager.addUser(newUser);
        } else {
            this.errorLabelStringProperty.set(UI.GuiMessages.USER_EXISTS);
        }
    }

    public User getUser() {
        return this.userManager.getUser(this.usernameStringProperty.get(), this.passwordStringProperty.get());
    }

    public boolean validateCreateAccount() {
        if (!this.emailStringProperty.get().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            this.errorLabelStringProperty.set(UI.GuiMessages.INVALID_EMAIL);
            return false;
        }
        if (this.passwordStringProperty.get().length() < 7) {
            this.errorLabelStringProperty.set(UI.GuiMessages.INVALID_PASSWORD);
            return false;
        }
        if (!this.passwordStringProperty.get().equals(this.confirmPasswordStringProperty.get())) {
            this.errorLabelStringProperty.set(UI.GuiMessages.MISMATCH_PASSWORD);
            return false;
        }
        return true;
    }
}
