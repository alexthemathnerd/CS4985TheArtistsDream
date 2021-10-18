package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for a custom control to handle displaying a set of tags.
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class TagsPane extends FlowPane {

    private final ListProperty<Tag> tagsListProperty;
    private final ListProperty<Tag> addedTagsListProperty;
    private final List<TagButton> selectedTagsButtons;

    /**
     * Creates a TagPane object
     *
     * @precondition none
     * @postcondition getStyleClass().contains('tags-pane') && tagsSetProperty().isEmpty()
     */
    public TagsPane() {
        this.getStyleClass().add("tags-pane");
        this.tagsListProperty = new SimpleListProperty<Tag>();
        this.addedTagsListProperty = new SimpleListProperty<Tag>();
        this.selectedTagsButtons = new ArrayList<TagButton>();
        this.tagsListProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.getChildren().clear();
                this.getChildren().addAll(this.selectedTagsButtons);
                this.setupSearchedButtons(newValue);
            }
        });
    }

    private void setupSearchedButtons(List<Tag> tags) {
        for (Tag aTag : tags) {
            TagButton button = new TagButton(aTag);
            if (!this.selectedTagsButtons.contains(button)) {
                button.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        this.selectedTagsButtons.add(button);
                    } else {
                        this.selectedTagsButtons.remove(button);
                    }
                });
                this.getChildren().add(button);
            }
        }
    }

    /**
     * Get the tags set property
     *
     * @return the tagsSet Property
     * @preconditon none
     * @postcondtion none
     */
    public ListProperty<Tag> tagsListProperty() {
        return this.tagsListProperty;
    }


    /**
     * Gets the added buttons
     *
     * @precondition none
     * @postcondition none
     *
     * @return the added buttons
     */
    public List<TagButton> getAddedButtons() {
        return this.selectedTagsButtons;
    }

    /**
     * Get the added tags set property
     *
     * @return the addedTagsSet Property
     * @preconditon none
     * @postcondtion none
     */
    public ListProperty<Tag> addedTagsSetProperty() {
        return this.addedTagsListProperty;
    }

}
