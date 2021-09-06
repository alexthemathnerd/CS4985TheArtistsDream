package edu.westga.devops.theartistsdreamclient.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Handle Filtering Tags, Users, and Artwork for the Artist's Dream Appliction
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class FilterManager {

    /**
     * Filters a tagManager by the content given. Returning a list of tags found
     *
     * @precondition tagManager != null && content != null
     * @postcondition none
     *
     * @param tagManager the tag manager to be filtered
     * @param content the content to filter with
     * @return a list of tags that contain the given content
     */
    public static List<Tag> filterTagsByName(TagManager tagManager, String content) {
        if (tagManager == null) {
            throw new IllegalArgumentException();
        }
        if (content == null) {
            throw new IllegalArgumentException();
        }
        List<Tag> filteredTags = new ArrayList<Tag>();
        if (content.isEmpty()) {
            return filteredTags;
        }
        for (Tag aTag: tagManager) {
            if (aTag.getName().contains(content.toLowerCase())) {
                filteredTags.add(aTag);
            }
        }
        return filteredTags;
    }

}
