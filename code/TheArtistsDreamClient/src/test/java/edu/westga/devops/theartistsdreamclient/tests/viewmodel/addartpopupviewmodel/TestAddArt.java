package edu.westga.devops.theartistsdreamclient.tests.viewmodel.addartpopupviewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.viewmodel.AddArtPopupViewModel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class TestAddArt {

    @Mock
    private ArtworkManager artworkManager;

    @Mock
    private TagManager tagManager;

    @Mock
    private User user;

    private Image jpegImage;
    private Image jpgImage;
    private Image pngImage;

    @Start
    void start(Stage stage) {
        this.jpegImage = new Image(TestAddArt.class.getResource("test_jpeg.jpeg").toExternalForm());
        this.jpgImage = new Image(TestAddArt.class.getResource("test_jpg.jpg").toExternalForm());
        this.pngImage = new Image(TestAddArt.class.getResource("test_png.png").toExternalForm());
    }


    @Test
    void testJpeg() {
        Mockito.when(this.user.getUserId()).thenReturn(0);
        User.setUser(this.user);
        ArtworkManager.setArtworkManager(this.artworkManager);
        AddArtPopupViewModel test = new AddArtPopupViewModel();
        test.imageProperty().setValue(this.jpegImage);
        test.tagsProperty().setValue("");
        test.titleProperty().setValue("");
        test.addArt();
        Mockito.verify(this.artworkManager).addArtwork(Mockito.any(),Mockito.eq(""), Mockito.eq(0), Mockito.eq(new ArrayList<>()), Mockito.anyString());
    }

    @Test
    void testJpg() {
        Mockito.when(this.user.getUserId()).thenReturn(0);
        User.setUser(this.user);
        ArtworkManager.setArtworkManager(this.artworkManager);
        AddArtPopupViewModel test = new AddArtPopupViewModel();
        test.imageProperty().setValue(this.jpgImage);
        test.tagsProperty().setValue("");
        test.titleProperty().setValue("");
        test.addArt();
        Mockito.verify(this.artworkManager).addArtwork(Mockito.any(),Mockito.eq(""), Mockito.eq(0), Mockito.eq(new ArrayList<>()), Mockito.anyString());
    }

    @Test
    void testPng() {
        Mockito.when(this.user.getUserId()).thenReturn(0);
        User.setUser(this.user);
        ArtworkManager.setArtworkManager(this.artworkManager);
        AddArtPopupViewModel test = new AddArtPopupViewModel();
        test.imageProperty().setValue(this.pngImage);
        test.tagsProperty().setValue("");
        test.titleProperty().setValue("");
        test.addArt();
        Mockito.verify(this.artworkManager).addArtwork(Mockito.any(),Mockito.eq(""), Mockito.eq(0), Mockito.eq(new ArrayList<>()), Mockito.anyString());
    }

    @Test
    void testWithTags() {
        Mockito.when(this.user.getUserId()).thenReturn(0);
        Mockito.when(this.tagManager.addTag("tag")).thenReturn(0);
        User.setUser(this.user);
        ArtworkManager.setArtworkManager(this.artworkManager);
        TagManager.setTagManager(this.tagManager);
        AddArtPopupViewModel test = new AddArtPopupViewModel();
        test.imageProperty().setValue(this.pngImage);
        test.tagsProperty().setValue("#tag");
        test.titleProperty().setValue("");
        test.addArt();
        Mockito.verify(this.tagManager).addTag("tag");
        Mockito.verify(this.artworkManager).addArtwork(Mockito.any(),Mockito.eq(""), Mockito.eq(0), Mockito.eq(List.of(0)), Mockito.anyString());
    }
}
