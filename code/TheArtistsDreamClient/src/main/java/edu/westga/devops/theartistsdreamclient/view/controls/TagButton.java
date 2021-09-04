package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class TagButton extends ToggleButton {

    private final ObjectProperty<Tag> tagProperty;

    /**
     * Initializes the FXML for the TagButton control
     */
    public TagButton(Tag tag) {
        super(tag.getName());
        this.getStyleClass().add("tag-button");
        this.tagProperty = new SimpleObjectProperty<Tag>(tag);
    }

    public ObjectProperty<Tag> tagProperty() {
        return this.tagProperty;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TagButton) {
            TagButton button = (TagButton) obj;
            return this.tagProperty.get().equals(button.tagProperty().get());
        }
        return false;
    }
}
