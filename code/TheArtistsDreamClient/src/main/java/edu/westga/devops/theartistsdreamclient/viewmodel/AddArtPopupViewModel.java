package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel for AddArtworkPopup
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 *
 */
public class AddArtPopupViewModel {

    private final StringProperty titleProperty;
    private final StringProperty tagsProperty;
    private final ObjectProperty<Image> imageProperty;

    /**
     * Creates a new AddArtworkPopupViewModel
     *
     * @precondition none
     * @postcondition imageProperty() != null && titleProperty().get() == "" && tagsProperty().get() == ""
     *
     */
    public AddArtPopupViewModel() {
        this.imageProperty = new SimpleObjectProperty<>();
        this.tagsProperty = new SimpleStringProperty("");
        this.titleProperty = new SimpleStringProperty("");
    }

    private List<Integer> addTags() {
        List<Integer> addedTags = new ArrayList<>();
        String[] tags = this.tagsProperty.get().split(" ");
        for (String aTag : tags) {
            if (aTag.matches("^#(\\w|\\d)+$")) {
                int index = TagManager.getTagManager().addTag(aTag.replace("#", ""));
                addedTags.add(index);
            }
        }
        return addedTags;
    }

    /**
     * Adds the art
     *
     * @precondition none
     * @postcondition none
     *
     */
    public void addArt() {
        byte[] buffer = this.parseImage();
        ArtworkManager.getArtworkManager().addArtwork(buffer, this.titleProperty.get(), User.getUser().getUserId(), this.addTags(), LocalDate.now().toString());
    }

    private byte[] parseImage() {
        Image image = this.imageProperty.get();
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try (ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream()) {
            if (image.getUrl().matches(".+\\.(jpg|jpeg)$")) {
                ImageIO.write(bufferedImage, "jpeg", byteArrayInputStream);
            } else {
                ImageIO.write(bufferedImage, "png", byteArrayInputStream);
            }
            return byteArrayInputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Gets the titleProperty
     *
     * @precondition none
     * @postcondition none
     *
     * @return the title property
     *
     */
    public StringProperty titleProperty() {
        return this.titleProperty;
    }

    /**
     * gets the tagsProperty
     *
     * @precondition none
     * @postcondition none
     *
     * @return the tagsProperty
     */
    public StringProperty tagsProperty() {
        return this.tagsProperty;
    }

    /**
     * Gets the imageProperty
     *
     * @precondition none
     * @postcondition none
     *
     * @return the imageProperty
     */
    public ObjectProperty<Image> imageProperty() {
        return this.imageProperty;
    }
}
