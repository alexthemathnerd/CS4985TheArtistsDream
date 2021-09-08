package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A locol implementation of the {@link TagManager}
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see TagManager
 * @see Tag
 */
public class LocalTagManager extends TagManager {

    private final ArrayList<Tag> tags;

    /**
     * Creates a Local Tag Manager
     *
     * @precondition none
     * @postcondition none
     */
    public LocalTagManager() {
        this.tags = new ArrayList<Tag>();
    }

    @Override
    public List<Tag> getTopTags(int amount, String content) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        if (content == null) {
            throw new IllegalArgumentException();
        }
        List<Tag> tagsWithName = this.getSearchTags(content);
        Collections.sort(tagsWithName);
        if (tagsWithName.size() <= amount) {
            return tagsWithName;
        }

        return tagsWithName.subList(0, amount);
    }

    private List<Tag> getSearchTags(String content) {
        List<Tag> filteredTags = new ArrayList<Tag>();
        if (content.isEmpty()) {
            return filteredTags;
        }
        for (Tag aTag: this) {
            if (aTag.getName().contains(content.toLowerCase())) {
                filteredTags.add(aTag);
            }
        }
        return filteredTags;
    }

    @Override
    public int addTag(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Tag aTag : this.tags) {
            if (aTag.getName().equals(name.toLowerCase())) {
                aTag.incrementUseCount();
                return aTag.getId();
            }
        }
        int id = this.tags.size();
        this.tags.add(new LocalTag(id, name));
        return id;
    }

    @Override
    public Iterator<Tag> iterator() {
        return this.tags.iterator();
    }
}
