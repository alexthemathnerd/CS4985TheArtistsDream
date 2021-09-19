package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TagManager Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class TagManager {

    /**
     * Gets the top ten tags
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to get the top ten tags
     */
    public static Request getTopTags(Object[] data) {
        int amount;
        String content;
        try {
            amount = ((Double) data[0]).intValue();
            content = (String) data[1];
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }
        List<Tag> tagsWithName = getSearchTags(content);
        Collections.sort(tagsWithName);
        if (tagsWithName.size() <= amount) {
            return new Request(tagsWithName);
        }

        return new Request(tagsWithName.subList(0, amount));
    }

    private static List<Tag> getSearchTags(String content) {
        List<Tag> filteredTags = new ArrayList<Tag>();
        if (content.isEmpty()) {
            return filteredTags;
        }
        for (Tag aTag: TheArtistsDreamServer.TAGS) {
            if (aTag.getName().contains(content.toLowerCase())) {
                filteredTags.add(aTag);
            }
        }
        return filteredTags;
    }

    /**
     * Adds a tag
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to add a tag
     */
    public static Request addTag(Object[] data) {
        String name;
        try {
            name = (String) data[0];
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }
        Tag tag = new Tag(TheArtistsDreamServer.TAGS.size(), name);
        int count = 0;
        for (Tag aTag : TheArtistsDreamServer.TAGS) {
            if (aTag.getName().equals(name.toLowerCase())) {
                aTag.incrementUseCount();
                return new Request(count);
            }
            count++;
        }
        TheArtistsDreamServer.TAGS.add(tag);
        return new Request(TheArtistsDreamServer.TAGS.size() - 1);
    }
}
