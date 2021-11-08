package edu.westga.devops.theartistsdreamclient.tests.view;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.view.FollowingPage;
import edu.westga.devops.theartistsdreamclient.view.RecommendedPage;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.framework.junit5.Stop;
import org.testfx.matcher.base.NodeMatchers;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.fail;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class TestHeaderGUI {

    @Mock
    private UserManager userManager;

    @Mock
    private ArtworkManager artworkManager;

    @Start
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Header());
        stage.setScene(scene);
        stage.show();
    }

    @BeforeEach
    public void init() throws TimeoutException {
        UserManager.setUserManager(this.userManager);
        ArtworkManager.setArtworkManager(this.artworkManager);
        FxToolkit.registerStage(Stage::new);
    }

    @AfterEach
    public void finish() throws TimeoutException {
        UserManager.setUserManager(null);
        ArtworkManager.setArtworkManager(null);
    }

    @Stop
    public void stop() throws Exception {
        FxToolkit.hideStage();
        FxToolkit.cleanupStages();
    }

    @Test
    public void testLoad() {
        verifyThat(".combo-box", NodeMatchers.isNotNull());
    }

}
