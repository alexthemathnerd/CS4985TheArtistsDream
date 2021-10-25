package edu.westga.devops.theartistsdreamclient.its;

import static org.testfx.api.FxAssert.*;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import javafx.application.Application;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.util.DebugUtils;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class LoginIT {

    @Mock
    private UserManager userManager;

    @Mock
    private ArtworkManager artworkManager;

    private Application application;

    @BeforeEach
    public void init() {
        UserManager.setUserManager(this.userManager);
        ArtworkManager.setArtworkManager(this.artworkManager);
    }

    @AfterEach
    public void finish() throws Exception {
        UserManager.setUserManager(null);
        ArtworkManager.setArtworkManager(null);
    }

    @Start
    public void start(Stage stage) throws Exception {
        this.application = new TheArtistsDreamApplication();
        application.start(stage);
        stage.toFront();
    }

    @Test
    public void testUserNotFound(FxRobot robot) {
        Mockito.when(this.userManager.findUser("", "")).thenReturn(null);
        robot.clickOn("#loginButton");
        verifyThat("OK", NodeMatchers.isVisible(), DebugUtils.informedErrorMessage(robot));
    }

    @Test
    public void testUserFound(FxRobot robot) {
        Mockito.when(this.userManager.findUser("admin", "admin")).thenReturn(new User(0, "admin@admin.com", "admin","admin", new byte[0]));
        robot.clickOn("#usernameTextField").write("admin");
        robot.clickOn("#passwordTextField").write("admin");
        robot.clickOn("#loginButton");
        verifyThat("#recommendedPage", NodeMatchers.isVisible(), DebugUtils.informedErrorMessage(robot));
    }

    @Test
    public void testCreateAccountInvalidEmail(FxRobot robot) {
        robot.clickOn("#createAccountButton")
                .clickOn("#emailTextField")
                .write("ssfdgdgf")
                .clickOn("#createAccountButton");
        verifyThat("#errorMessageLabel", LabeledMatchers.hasText("Must enter a valid email"), DebugUtils.informedErrorMessage(robot));
    }

    @Test
    public void testCreateAccountInvalidPassword(FxRobot robot) {
        robot.clickOn("#createAccountButton")
                .clickOn("#emailTextField")
                .write("admin@admin.com")
                .clickOn("#passwordTextField")
                .write("0")
                .clickOn("#createAccountButton");
        verifyThat("#errorMessageLabel", LabeledMatchers.hasText("Password must be at least 7 characters long"), DebugUtils.informedErrorMessage(robot));
    }

    @Test
    public void testCreateAccountMismatchPassword(FxRobot robot) {
        robot.clickOn("#createAccountButton")
                .clickOn("#emailTextField")
                .write("admin@admin.com")
                .clickOn("#passwordTextField")
                .write("1234567")
                .clickOn("#confirmPasswordTextField")
                .write("1234568")
                .clickOn("#createAccountButton");
        verifyThat("#errorMessageLabel", LabeledMatchers.hasText("Passwords must match"), DebugUtils.informedErrorMessage(robot));
    }

    @Test
    public void testCreateAccountValid(FxRobot robot) {
        robot.clickOn("#createAccountButton")
                .clickOn("#emailTextField")
                .write("admin@admin.com")
                .clickOn("#usernameTextField")
                .write("admin")
                .clickOn("#passwordTextField")
                .write("1234567")
                .clickOn("#confirmPasswordTextField")
                .write("1234567")
                .clickOn("#createAccountButton");
        verifyThat("LOGIN", NodeMatchers.isVisible(), DebugUtils.informedErrorMessage(robot));
    }

    @Test
    public void testCancelCreateAccount(FxRobot robot) {
        robot.clickOn("#createAccountButton")
                .clickOn("CANCEL");
        verifyThat("LOGIN", NodeMatchers.isVisible(), DebugUtils.informedErrorMessage(robot));
    }

}
