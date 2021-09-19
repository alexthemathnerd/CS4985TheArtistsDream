package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import javafx.beans.property.*;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.network.*;

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

    /**
     * Creates a new LoginViewModel
     *
     * @precondition none
     * @postcondition errorLabelStringProperty().get() == "" && usernameStringProperty().get() == "" && emailStringProperty().get() == "" && passwordStringProperty().get() == "" && confirmPasswordStringProperty().get() == ""
     */
    public LoginViewModel() {
        this.usernameStringProperty = new SimpleStringProperty("");
        this.passwordStringProperty = new SimpleStringProperty("");

        this.confirmPasswordStringProperty = new SimpleStringProperty("");
        this.emailStringProperty = new SimpleStringProperty("");
        this.errorLabelStringProperty = new SimpleStringProperty("");
    }

    /**
     * Gets the error label string property
     *
     * @precondition none
     * @postcondition noen
     *
     * @return the error label string property
     */
    public StringProperty errorLabelStringProperty() {
        return this.errorLabelStringProperty;
    }

    /**
     * Gets the username string property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the username string property
     */
    public StringProperty usernameStringProperty() {
        return this.usernameStringProperty;
    }

    /**
     * Gets the password string property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the password string property
     */
    public StringProperty passwordStringProperty() {
        return this.passwordStringProperty;
    }

    /**
     * Gets the confirm password string property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the confirm password string property
     */
    public StringProperty confirmPasswordStringProperty() {
        return this.confirmPasswordStringProperty;
    }

    /**
     * Gets the email string property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the email string property
     */
    public StringProperty emailStringProperty() {
        return this.emailStringProperty;
    }

    /**
     * Adds the new user that created an account
     *
     * @precondition usernameStringProperty().get() != "" && passwordStringProperty().get() != "" && emailStringProperty().get() != ""
     * @postcondition none
     */
    public void addUser() {
        UserManager.getUserManager().addUser(this.usernameStringProperty.get(), this.passwordStringProperty.get(), this.emailStringProperty.get());

        // if (!this.checkIfUserAlreadyExists(newUser)) {
        //     //this.userManager.addUser(newUser);
        //      } else {
        //     this.errorLabelStringProperty.set(UI.GuiMessages.USER_EXISTS);
        // }
    }

    /**
     * Gets the user that logged in
     *
     * @precondition usernameStringProperty().get() != "" passwordStringProperty().get() != ""
     * @postcondition none
     */
    public User getUser() {
        return UserManager.getUserManager().findUser(this.usernameStringProperty.get(), this.passwordStringProperty.get());
    }

    /**
     * Validates the values entered in when creating an account
     *
     * @precondition emailStringProperty().get() != "" && passwordStringProperty().get() != ""
     * @postcondition none
     */
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
