package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class FilterPopupViewModel {

    private StringProperty searchStringProperty;

    public FilterPopupViewModel() {
        this.searchStringProperty = new SimpleStringProperty();
    }

    public List<Tag> getFoundTags(String searchString) {
        return new ArrayList<Tag>(List.of(new Tag()));
    }

    public StringProperty searchStringProperty() {
        return searchStringProperty;
    }
}
