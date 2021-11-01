package edu.westga.devops.theartistsdreamclient.model;

import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * Handle Filtering Tags, Users, and Artwork for the Artist's Dream Application
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class FilterManager {

    /**
     * Filters a tagManager by the content given. Returning a list of tags found
     *
     * @param tagManager the tag manager to be filtered
     * @param content    the content to filter with
     * @return a list of tags that contain the given content
     * @precondition tagManager != null && content != null
     * @postcondition none
     */
    public static List<Tag> filterTagsByName(TagManager tagManager, String content) {
	    if (tagManager == null) {
		    throw new IllegalArgumentException(UI.ErrorMessages.TAG_MANAGER_NULL);
	    }
	    if (content == null) {
		    throw new IllegalArgumentException(UI.ErrorMessages.CONTENT_NULL);
	    }
	    List<Tag> filteredTags = new ArrayList<Tag>();
	    if (content.isEmpty()) {
		    return filteredTags;
	    }
	    if (tagManager instanceof LocalTagManager) {
		    LocalTagManager localTagManager = (LocalTagManager) tagManager;
		    for (Tag aTag : localTagManager) {
			    if (aTag.getName().contains(content.toLowerCase())) {
				    filteredTags.add(aTag);
			    }
		    }
		    return filteredTags;
	    }
        return null;
    }

}
