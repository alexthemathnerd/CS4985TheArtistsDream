package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class TagButton extends Button {

    /**
     * Initializes the FXML for the TagButton control
     */
    public TagButton(Tag tag, boolean isClicked) {
        this.setText(tag.getName());
    }

}
