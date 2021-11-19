package edu.westga.devops.theartistsdreamserver.tests.model.commissionmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Commission;
import edu.westga.devops.theartistsdreamserver.model.CommissionManager;
import edu.westga.devops.theartistsdreamserver.model.Request;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class TestAddCommission {

    @AfterEach
    void destroy() {
        TheArtistsDreamServer.COMMISSIONS.clear();
    }

    @Test
    void TestInvaidParams() {
        Request request = CommissionManager.addCommission(new Object[0]);
        assertNotNull(request.getError());
    }

    @Test
    void TestSuccessfulAdd() {
        Request request = CommissionManager.addCommission(new Object[] {0.0, 1.0, "ABSTRACT", 1.0, "Test", "Test"});
        assertEquals(0, (int) request.getData());
    }

}
