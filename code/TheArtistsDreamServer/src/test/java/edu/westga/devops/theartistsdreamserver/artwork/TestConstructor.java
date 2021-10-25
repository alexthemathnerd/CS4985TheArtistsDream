 package edu.westga.devops.theartistsdreamserver.artwork;

import edu.westga.devops.theartistsdreamserver.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.devops.theartistsdreamserver.*;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;

public class TestConstructor {
    @Test
    void testNullImageData() {
        List<Integer> tagIDs = new ArrayList<Integer>();
        tagIDs.add(1);
        tagIDs.add(2);
        tagIDs.add(3);
        assertThrows(IllegalArgumentException.class, () -> {
            new Artwork(null, "title", 0, tagIDs, 0, "12-30-2000");
        });
    }
    
}
