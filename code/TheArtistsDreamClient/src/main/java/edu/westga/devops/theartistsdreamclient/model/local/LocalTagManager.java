package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LocalTagManager extends TagManager {

    private final ArrayList<Tag> tags;

    public LocalTagManager() {
        this.tags = new ArrayList<Tag>();
    }

    @Override
    public List<Tag> getTopTenTags(String name) {
        List<Tag> tagsWithName = FilterManager.filterTagsByName(this, name);
        if (tagsWithName.size() <= 10) {
            return tagsWithName;
        }
        Collections.sort(tagsWithName);
        return tagsWithName.subList(0, 10);
    }

    @Override
    public void addTag(String name) {
        for (Tag aTag: this.tags) {
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
