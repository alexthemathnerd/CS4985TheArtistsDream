package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;

import javafx.beans.property.SetProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;

import java.util.TreeSet;

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
    private final SetProperty<Tag> searchTagsSetProperty;
    private final SetProperty<Tag> addedTagsSetProperty;

    /**
     * Creates a instance of {@link FilterPopupViewModel}
     *
     * @precondition none
     * @postcondition searchStringProperty().isNotNull() && searchTagsSetProperty().isNotNull &&
     * addedTagsSetProperty().isNotNull()
     */
    public FilterPopupViewModel() {
        this.searchStringProperty = new SimpleStringProperty();
        this.searchTagsSetProperty = new SimpleSetProperty<Tag>();
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
        TreeSet<Tag> tags = new TreeSet<Tag>(TagManager.getTagManager().getTopTags(amount, this.searchStringProperty.get()));
        this.searchTagsSetProperty.setValue(FXCollections.observableSet(tags));
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
    public SetProperty<Tag> searchTagsSetProperty() {
        return this.searchTagsSetProperty;
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
