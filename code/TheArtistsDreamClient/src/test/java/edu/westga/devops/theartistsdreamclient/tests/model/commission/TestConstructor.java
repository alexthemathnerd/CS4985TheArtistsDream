package edu.westga.devops.theartistsdreamclient.tests.model.commission;

import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.Style;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test the constructor of the commissions class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestConstructor {
    
    @Test
    void testNullStyle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(1, null, 100.00, "description", "title");
        });
    }

    @Test
    void testNegativeUserId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(-1, Style.MODERN, 100.00, "description", "title");
        });
    }

    @Test
    void testNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(1, Style.MODERN, 100.00, null, "title");
        });
    }

    @Test
    void testEmptyDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(1, Style.MODERN, 100.00, "", "title");
        });
    }

    @Test
    void testNegativeBudget() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(1, Style.MODERN, 0.0, "Description","title");
        });
    }

    @Test
    void testNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(1, Style.MODERN, 100.0, "Description",null);
        });
    }

    @Test
    void testEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Commission(1, Style.MODERN, 100.0, "Description","");
        });
    }


    @Test
    void testValidCommission() {
        Commission testCommission = new Commission(1, Style.MODERN, 100.00, "Description", "title");
        assertAll(() -> {
            assertEquals(1, testCommission.getUserId());
            assertEquals(Style.MODERN, testCommission.getStyle());
            assertEquals(100.00, testCommission.getBudget());
            assertEquals("Description", testCommission.getDescription());
        });
    }
}
