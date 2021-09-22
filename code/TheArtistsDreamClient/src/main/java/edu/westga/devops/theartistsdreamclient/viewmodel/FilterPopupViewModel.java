package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;


import javafx.collections.FXCollections;

import java.util.List;

/**
 * The ViewModel for handleing the logic behind the {@link FilterPopup}
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see Tag
 * @see FilterPopup
 * @see FilterManager
 */
public class FilterPopupViewModel {

    private final StringProperty searchStringProperty;
    private final ListProperty<Tag> searchTagsListProperty;
    private final SetProperty<Tag> addedTagsSetProperty;

    /**
     * Creates a instance of {@link FilterPopupViewModel}
     *
     * @precondition none
     * @postcondition searchStringProperty().isNotNull() && searchTagsSetProperty().isNotNull &&
     * addedTagsSetProperty().isNotNull()
     */
    public FilterPopupViewModel() {
        this.searchStringProperty = new SimpleStringProperty("");
        this.searchTagsListProperty = new SimpleListProperty<Tag>();
        this.addedTagsSetProperty = new SimpleSetProperty<Tag>();
    }

    /**
     * Searchs the first top tags given the amount of tags.
     *
     * @param amount the amount of tags to be recived
     * @precondition none
     * @postcondition searchTagsSetProperty().isNotEmpty()
     */
    public void searchTags(int amount) {
        List<Tag> tags = TagManager.getTagManager().getTopTags(amount, this.searchStringProperty.get());
        this.searchTagsListProperty.setValue(FXCollections.observableList(tags));
    }

    /**
     * Gets the searchStringProperty
     *
     * @return the searchStringProperty
     * @precondition none
     * @postcondition none
     */
    public StringProperty searchStringProperty() {
        return this.searchStringProperty;
    }

    /**
     * Gets the searchTagsSetProperty
     *
     * @return the searchTagsSetProperty
     * @precondition none
     * @postcondition none
     */
    public ListProperty<Tag> searchTagsListProperty() {
        return this.searchTagsListProperty;
    }

    /**
     * Gets the searchTagsSetProperty
     *
     * @return the searchTagsSetProperty
     * @precondition none
     * @postcondition none
     */
    public SetProperty<Tag> addedTagsSetProperty() {
        return this.addedTagsSetProperty;
    }
}
