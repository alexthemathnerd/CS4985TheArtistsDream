package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A class for a custom control to handle displaying a set of tags.
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class TagsPane extends FlowPane {

    private SetProperty<Tag> tagsSetProperty;
    private SetProperty<Tag> addedTagsSetProperty;
    private List<TagButton> selectedTagsButtons;

    /**
     * Creates a TagPane object
     *
     * @precondition none
     * @postcondition getStyleClass().contains(' tags - pane ') && tagsSetProperty().isEmpty()
     */
    public TagsPane() {
        this.getStyleClass().add("tags-pane");
        this.tagsSetProperty = new SimpleSetProperty<Tag>();
        this.addedTagsSetProperty = new SimpleSetProperty<Tag>();
        this.selectedTagsButtons = new ArrayList<TagButton>();
        this.tagsSetProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.getChildren().clear();
                this.getChildren().addAll(this.selectedTagsButtons);
                this.setupSearchedButtons(newValue);
            }
        });
    }

    private void setupSearchedButtons(Set<Tag> tags) {
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
    public SetProperty<Tag> tagsSetProperty() {
        return this.tagsSetProperty;
    }


    /**
     * Get the added tags set property
     *
     * @return the addedTagsSet Property
     * @preconditon none
     * @postcondtion none
     */
    public SetProperty<Tag> addedTagsSetProperty() {
        return this.addedTagsSetProperty;
    }

}
