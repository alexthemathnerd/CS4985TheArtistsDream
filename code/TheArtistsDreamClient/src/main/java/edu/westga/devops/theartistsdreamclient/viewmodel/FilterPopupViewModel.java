package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.view.controls.TagButton;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.*;

public class FilterPopupViewModel {

    private final StringProperty searchStringProperty;
    private final SetProperty<Tag> searchTagsSetProperty;
    private final SetProperty<Tag> addedTagsSetProperty;

    public FilterPopupViewModel() {
        this.searchStringProperty = new SimpleStringProperty();
        this.searchTagsSetProperty = new SimpleSetProperty<Tag>();
        this.addedTagsSetProperty = new SimpleSetProperty<Tag>();
    }

    public void searchTags(int amount) {
        this.searchTagsSetProperty.setValue(FXCollections.observableSet(new TreeSet<Tag>(this.getTagsFromSearch(amount))));
    }

    private List<Tag> getTagsFromSearch(int amount) {
        List<Tag> searchTags = FilterManager.filterTagsByName(TheArtistsDreamApplication.tagManager, this.searchStringProperty.get());
        Collections.sort(searchTags);
        if (searchTags.size() <= amount) {
            return searchTags;
        }
        return searchTags.subList(0, amount);
    }

    public StringProperty searchStringProperty() {
        return this.searchStringProperty;
    }
    public SetProperty<Tag> searchTagsSetProperty() {
        return this.searchTagsSetProperty;
    }
    public SetProperty<Tag> addedTagsSetProperty() {
        return this.addedTagsSetProperty;
    }
}
