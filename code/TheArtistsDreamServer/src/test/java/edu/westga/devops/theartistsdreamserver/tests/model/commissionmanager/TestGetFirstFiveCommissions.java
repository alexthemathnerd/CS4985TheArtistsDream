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

public class TestGetFirstFiveCommissions {



    @AfterEach
    void destroy() {
        TheArtistsDreamServer.COMMISSIONS.clear();
    }

    @Test
    void testInvalidDataFirstParam() {
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"NOT TYPE", 0});
        assertNotNull(request.getError());
    }

    @Test
    void testInvalidDataSecondParam() {
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"OPEN", "HI"});
        assertNotNull(request.getError());
    }

    @Test
    void testInvalidDataNotTwoParams() {
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"OPEN", -1});

    }

    @Test
    void testValidOpenLessThanFive() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, -1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST"));
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"OPEN", 0.0});
        assertEquals(1, ((ArrayList) request.getData()).size());
    }

    @Test
    void testNoOpenLessThanFive() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, 5, 0, Style.ABSTRACT, 1.0, "TEST", "TEST"));
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"OPEN", 0.0});
        assertEquals(0, ((ArrayList) request.getData()).size());
    }

    @Test
    void testValidOpenMoreThanFive() {
        for (int i = 0; i < 5; i++) {
            TheArtistsDreamServer.COMMISSIONS.add(new Commission(i, -1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST"));
        }
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"OPEN", 0.0});
        assertEquals(5, ((List) request.getData()).size());
    }

    @Test
    void testValidDirectLessThanFive() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, 1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST"));
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"DIRECT", 1.0});
        assertEquals(1, ((ArrayList) request.getData()).size());
    }

    @Test
    void testNoDirectLessThanFive() {
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(0, -1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST"));
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"DIRECT", 1.0});
        assertEquals(0, ((ArrayList) request.getData()).size());
    }

    @Test
    void testValidDirectMoreThanFive() {
        for (int i = 0; i < 5; i++) {
            TheArtistsDreamServer.COMMISSIONS.add(new Commission(i, 1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST"));
        }
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"DIRECT", 1.0});
        assertEquals(5, ((List) request.getData()).size());
    }

    @Test
    void testValidOngoingLessThanFive() {
        Commission commission = new Commission(0, 1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST");
        commission.setOngoing(true);
        TheArtistsDreamServer.COMMISSIONS.add(commission);
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"ONGOING", 1.0});
        assertEquals(1, ((ArrayList) request.getData()).size());
    }

    @Test
    void testNoOngoingLessThanFive() {
        Commission commission = new Commission(0, 1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST");
        TheArtistsDreamServer.COMMISSIONS.add(commission);
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"ONGOING", 1.0});
        assertEquals(0, ((ArrayList) request.getData()).size());
    }

    @Test
    void testValidOngoingMoreThanFive() {
        for (int i = 0; i < 5; i++) {
            Commission commission = new Commission(i, 1, 0, Style.ABSTRACT, 1.0, "TEST", "TEST");
            commission.setOngoing(true);
            TheArtistsDreamServer.COMMISSIONS.add(commission);
        }
        Request request = CommissionManager.getFirstFiveCommissions(new Object[] {"ONGOING", 1.0});
        assertEquals(5, ((List) request.getData()).size());
    }
}
