package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Login View Model
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class LoginViewModel {
    private final StringProperty usernameProperty;
    private final StringProperty passwordProperty;
    private final StringProperty confirmPasswordProperty;
    private final StringProperty emailProperty;
    private final StringProperty errorProperty;

    /**
     * Creates a new LoginViewModel
     *
     * @precondition none
     * @postcondition errorProperty().get() == "" && usernameProperty().get() == "" && emailProperty().get() == "" && passwordProperty().get() == "" && confirmPasswordProperty().get() == ""
     */
    public LoginViewModel() {
        this.usernameProperty = new SimpleStringProperty("");
        this.passwordProperty = new SimpleStringProperty("");
        this.confirmPasswordProperty = new SimpleStringProperty("");
        this.emailProperty = new SimpleStringProperty("");
        this.errorProperty = new SimpleStringProperty("");
    }

    /**
     * Gets the error label property
     *
     * @return the error label property
     * @precondition none
     * @postcondition none
     */
    public StringProperty errorProperty() {
        return this.errorProperty;
    }

    /**
     * Gets the username property
     *
     * @return the username property
     * @precondition none
     * @postcondition none
     */
    public StringProperty usernameProperty() {
        return this.usernameProperty;
    }

    /**
     * Gets the password property
     *
     * @return the password property
     * @precondition none
     * @postcondition none
     */
    public StringProperty passwordProperty() {
        return this.passwordProperty;
    }

    /**
     * Gets the confirmed password property
     *
     * @return the confirmed password property
     * @precondition none
     * @postcondition none
     */
    public StringProperty confirmPasswordProperty() {
        return this.confirmPasswordProperty;
    }

    /**
     * Gets the email property
     *
     * @return the email property
     * @precondition none
     * @postcondition none
     */
    public StringProperty emailProperty() {
        return this.emailProperty;
    }

    /**
     * Adds the new user that created an account
     *
     * @precondition usernameProperty().get() != "" && passwordProperty().get() != "" && emailProperty().get() != ""
     * @postcondition none
     */
    public void addUser() {
        UserManager.getUserManager().addUser(this.usernameProperty.get(), this.passwordProperty.get(), this.emailProperty.get());
    }

    /**
     * Gets the user that logged in
     *
     * @return the user
     * @precondition usernameProperty().get() != "" passwordProperty().get() != ""
     * @postcondition none
     */
    public User getUser() {
        return UserManager.getUserManager().findUser(this.usernameProperty.get(), this.passwordProperty.get());
    }

    /**
     * Validates the values entered in when creating an account
     *
     * @return true if the entered information is valid. False if otherwise
     * @precondition emailProperty().get() != "" && passwordProperty().get() != ""
     * @postcondition none
     */
    public boolean validateCreateAccount() {
        if (!this.emailProperty.get().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            this.errorProperty.set(UI.GuiMessages.INVALID_EMAIL);
            return false;
        }
        if (this.passwordProperty.get().length() < 7) {
            this.errorProperty.set(UI.GuiMessages.INVALID_PASSWORD);
            return false;
        }
        if (!this.passwordProperty.get().equals(this.confirmPasswordProperty.get())) {
            this.errorProperty.set(UI.GuiMessages.MISMATCH_PASSWORD);
            return false;
        }
        return true;
    }
}
