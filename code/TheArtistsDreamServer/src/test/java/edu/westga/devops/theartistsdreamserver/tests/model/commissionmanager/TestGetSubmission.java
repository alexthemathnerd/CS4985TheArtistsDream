package edu.westga.devops.theartistsdreamserver.tests.model.commissionmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Commission;
import edu.westga.devops.theartistsdreamserver.model.CommissionManager;
import edu.westga.devops.theartistsdreamserver.model.Request;
import edu.westga.devops.theartistsdreamserver.model.Style;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGetSubmission {

    @AfterEach
    void destroy() {
        TheArtistsDreamServer.COMMISSIONS.clear();
    }

    @Test
    void TestInvaidParams() {
        Request request = CommissionManager.getSubmission(new Object[0]);
        assertNotNull(request.getError());
    }

    @Test
    void testValidGet() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, 1, 2, Style.ABSTRACT, 1.0, "test", "test"));
        CommissionManager.submitImage(new Object[] {0.0, new ArrayList<Double>()});
        Request request = CommissionManager.getSubmission(new Object[] {0.0});
        assertEquals(0, ((byte[]) request.getData()).length);
    }
}
