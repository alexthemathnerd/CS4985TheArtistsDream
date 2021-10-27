package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

/**
 * The ViewModel for handling the logic behind the {@link FilterPopup}
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see Tag
 * @see FilterPopup
 * @see FilterManager
 */
public class FilterPopupViewModel {

    private final StringProperty searchTermProperty;
    private final ListProperty<Tag> searchTagsProperty;
    private final SetProperty<Tag> addedTagsProperty;

    /**
     * Creates an instance of {@link FilterPopupViewModel}
     *
     * @precondition none
     * @postcondition searchStringProperty().isNotNull() && searchTagsSetProperty().isNotNull &&
     * addedTagsSetProperty().isNotNull()
     */
    public FilterPopupViewModel() {
        this.searchTermProperty = new SimpleStringProperty("");
        this.searchTagsProperty = new SimpleListProperty<Tag>();
        this.addedTagsProperty = new SimpleSetProperty<Tag>();
    }

    /**
     * Searches the first top tags given the amount of tags.
     *
     * @param amount the amount of tags to be received
     * @precondition none
     * @postcondition searchTagsSetProperty().isNotEmpty()
     */
    public void searchTags(int amount) {
        List<Tag> tags = TagManager.getTagManager().getTopTags(amount, this.searchTermProperty.get());
        this.searchTagsProperty.setValue(FXCollections.observableList(tags));
    }

    /**
     * Gets the searchTermProperty
     *
     * @return the searchTermProperty
     * @precondition none
     * @postcondition none
     */
    public StringProperty searchTermProperty() {
        return this.searchTermProperty;
    }

    /**
     * Gets the searchTagsProperty
     *
     * @return the searchTagsProperty
     * @precondition none
     * @postcondition none
     */
    public ListProperty<Tag> searchTagsProperty() {
        return this.searchTagsProperty;
    }

    /**
     * Gets the addedTagsProperty
     *
     * @return the addedTagsSetProperty
     * @precondition none
     * @postcondition none
     */
    public SetProperty<Tag> addedTagsProperty() {
        return this.addedTagsProperty;
    }
}
