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

public class AddArtPopupViewModel {

    private StringProperty titleProperty;
    private StringProperty tagsProperty;
    private ObjectProperty<Image> imageObjectProperty;

    public AddArtPopupViewModel() {
        this.imageObjectProperty = new SimpleObjectProperty<>();
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

    public void addArt() {
        Image image = this.imageObjectProperty.get();
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try (ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream()) {
            if (image.getUrl().matches(".\\.jpg")) {
                ImageIO.write(bufferedImage, "jpeg", byteArrayInputStream);
            } else {
                ImageIO.write(bufferedImage, "png", byteArrayInputStream);
            }
            byte[] buffer = byteArrayInputStream.toByteArray();
            ArtworkManager.getArtworkManager().addArtwork(buffer, this.titleProperty.get(), User.getUser().getUserId(), this.addTags(), LocalDate.now().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public StringProperty titleProperty() {
        return this.titleProperty;
    }

    public StringProperty tagsProperty() {
        return this.tagsProperty;
    }

    public ObjectProperty<Image> imageObjectProperty() {
        return this.imageObjectProperty;
    }
}
