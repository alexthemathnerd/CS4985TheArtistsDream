package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TagsPane extends FlowPane {

    private final SetProperty<Tag> tagsSetProperty;
    private final List<TagButton> selectedTagsButtons;

    public TagsPane() {
        this.getStyleClass().add("tags-pane");
        this.tagsSetProperty = new SimpleSetProperty<Tag>();
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
                        selectedTagsButtons.add(button);
                    } else {
                        selectedTagsButtons.remove(button);
                    }
                });
                this.getChildren().add(button);
            }
        }
    }

    public SetProperty<Tag> tagsSetProperty() {
        return this.tagsSetProperty;
    }

}
