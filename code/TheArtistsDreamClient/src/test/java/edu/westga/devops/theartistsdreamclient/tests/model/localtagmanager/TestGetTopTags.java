package edu.westga.devops.theartistsdreamclient.tests.model.localtagmanager;

import edu.westga.devops.theartistsdreamclient.model.FilterManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTag;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class TestGetTopTags {

    @Test
    public void testWhenAmountIsNegative() {
        TagManager tagManager = new LocalTagManager();
        assertThrows(IllegalArgumentException.class, () -> {
            tagManager.getTopTags(-1, "");
        });
    }

    @Test
    public void testWhenContentIsNull() {
        TagManager tagManager = new LocalTagManager();
        assertThrows(IllegalArgumentException.class, () -> {
            tagManager.getTopTags(0, null);
        });
    }

//    @Test
//    public void testWhenSearchedListIsLessThanAmount() {
//        try (MockedStatic<FilterManager> staticFilterManager = Mockito.mockStatic(FilterManager.class)) {
//            TagManager tagManager = new LocalTagManager();
//            staticFilterManager.when(() -> FilterManager.filterTagsByName(tagManager, "less than")).thenReturn(new ArrayList<Tag>(List.of(new Tag[]{
//                    new LocalTag(0, "a"),
//                    new LocalTag(1, "b")
//            })));
//            List<Tag> result = tagManager.getTopTags(3, "less than");
//            assertEquals(2, result.size());
//        }
//    }

    @Test
    public void testWhenSearchedListIsLessThanAmount() {
        TagManager tagManager = new LocalTagManager();
        tagManager.addTag("aa");
        tagManager.addTag("ba");
        tagManager.addTag("cb");
        List<Tag> result = tagManager.getTopTags(3, "a");
        assertEquals(2, result.size());
    }

    @Test
    public void testWhenSearchedListIsEqualAmount() {
//        this.staticFilterManager.when(() -> FilterManager.filterTagsByName(any(TagManager.class), "equals")).thenReturn(List.of(
//                new LocalTag(""),
//                new LocalTag(""),
//                new LocalTag("")
//        ));
        TagManager tagManager = new LocalTagManager();
        tagManager.addTag("aa");
        tagManager.addTag("ba");
        tagManager.addTag("cb");
        List<Tag> result = tagManager.getTopTags(2, "a");
        assertEquals(2, result.size());
    }


    @Test
    public void testWhenSearchedListIsMoreThanAmount() {
//        this.staticFilterManager.when(() -> FilterManager.filterTagsByName(any(TagManager.class), "more than")).thenReturn(List.of(
//                new LocalTag(""),
//                new LocalTag(""),
//                new LocalTag(""),
//                new LocalTag("")
//        ));
        TagManager tagManager = new LocalTagManager();
        tagManager.addTag("aa");
        tagManager.addTag("ba");
        tagManager.addTag("ca");
        tagManager.addTag("ba");
        tagManager.addTag("cb");
        List<Tag> result = tagManager.getTopTags(2, "a");
        assertEquals(2, result.size());
    }

}
