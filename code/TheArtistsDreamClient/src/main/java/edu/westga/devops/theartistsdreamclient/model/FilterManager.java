package edu.westga.devops.theartistsdreamclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FilterManager {

    public static List<Tag> filterTagsByName(TagManager tagManager, String name) {
        List<Tag> filteredTags = new ArrayList<Tag>();
        if (name.isEmpty()) {
            return filteredTags;
        }
        for (Tag aTag: tagManager) {
            if (aTag.getName().contains(name.toLowerCase())) {
                filteredTags.add(aTag);
            }
        }
        return filteredTags;
    }

}
