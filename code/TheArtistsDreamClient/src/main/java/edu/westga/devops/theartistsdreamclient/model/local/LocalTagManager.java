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
        List<Tag> tagsWithName = FilterManager.filterTagsByName(this, content);
        if (tagsWithName.size() <= amount) {
            return tagsWithName;
        }
        Collections.sort(tagsWithName);
        return tagsWithName.subList(0, 10);
    }

    @Override
    public void addTag(String name) {
        for (Tag aTag : this.tags) {
            if (aTag.getName().equals(name.toLowerCase())) {
                aTag.incrementUseCount();
                return;
            }
        }
        this.tags.add(new LocalTag(name));
    }

    @Override
    public Iterator<Tag> iterator() {
        return this.tags.iterator();
    }
}
