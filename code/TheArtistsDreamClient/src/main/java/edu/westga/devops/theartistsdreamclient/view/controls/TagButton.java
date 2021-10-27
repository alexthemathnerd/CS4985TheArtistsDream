package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ToggleButton;

/**
 * A custom control for a tag button.
 *
 * @author Alexander Schmidt
 * @version Fall2021
 * @see Tag
 */
public class TagButton extends ToggleButton {

    private final ObjectProperty<Tag> tagProperty;

    /**
     * Initializes the FXML for the TagButton control
     *
     * @param tag the tag to be stored in the button
     * @precondition tag != null
     * @postcondition getText().equals(tag.getName ()) && getStyleClass().contains("tag-button") && tagProperty().get().equals(tag)
     */
    public TagButton(Tag tag) {
        super();
        if (tag == null) {
            throw new IllegalArgumentException();
        }
        this.setText(tag.getName());
        this.getStyleClass().add("tag-button");
        this.tagProperty = new SimpleObjectProperty<Tag>(tag);
    }

    /**
     * Gets the tag property of the button
     *
     * @return the tag property
     * @precondition none
     * @postcondition none
     */
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
