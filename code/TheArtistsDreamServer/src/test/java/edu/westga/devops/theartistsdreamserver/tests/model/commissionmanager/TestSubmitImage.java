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

import java.util.ArrayList;
import java.util.List;

public class TestSubmitImage {

    @AfterEach
    void destroy() {
        TheArtistsDreamServer.COMMISSIONS.clear();
    }

    @Test
    void TestInvaidParams() {
        Request request = CommissionManager.submitImage(new Object[0]);
        assertNotNull(request.getError());
    }

    @Test
    void TestAddWithEmptyImage() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, 1, 2, Style.ABSTRACT, 1.0, "test", "test"));
        Request request = CommissionManager.submitImage(new Object[] {0.0, new ArrayList<Double>()});
        assertTrue((boolean) request.getData());
    }

    @Test
    void TestAddWithImage() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, 1, 2, Style.ABSTRACT, 1.0, "test", "test"));
        Request request = CommissionManager.submitImage(new Object[] {0.0, new ArrayList<Double>(List.of(1.0, -1.0))});
        assertTrue((boolean) request.getData());
    }

}
