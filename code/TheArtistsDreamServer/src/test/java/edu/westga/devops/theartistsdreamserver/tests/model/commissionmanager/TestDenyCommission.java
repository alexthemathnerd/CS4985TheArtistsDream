package edu.westga.devops.theartistsdreamserver.tests.model.commissionmanager;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Commission;
import edu.westga.devops.theartistsdreamserver.model.CommissionManager;
import edu.westga.devops.theartistsdreamserver.model.Request;
import edu.westga.devops.theartistsdreamserver.model.Style;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestDenyCommission {

    @AfterEach
    void destroy() {
        TheArtistsDreamServer.COMMISSIONS.clear();
    }

    @Test
    void testInvalidParam() {
        Request request = CommissionManager.denyCommission(new Object[] {"hi"});
        assertNotNull(request.getError());
    }

    @Test
    void testInvalidCommissionNotFound() {
        Request request = CommissionManager.denyCommission(new Object[] {0});
        assertNotNull(request.getError());
    }

    @Test
    void testValidDeny() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, 1, 1, Style.ABSTRACT, 1.0 , "Test", "Test"));
        Request request = CommissionManager.denyCommission(new Object[] {0.0});
        assertTrue((boolean) request.getData());
    }

}
