package edu.westga.devops.theartistsdreamclient.tests.model.commissionmanager;

import edu.westga.devops.theartistsdreamclient.model.CommissionManager;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class TestGetCommissionManager {

    @Mock
    CommissionManager commissionManager;

    @BeforeEach
    void init() {
        CommissionManager.setCommissionManager(null);
    }

    @Test
    void testNull() {
        assertNull(CommissionManager.getCommissionManager());
    }

    @Test
    void testNotNull() {
        CommissionManager.setCommissionManager(this.commissionManager);
        assertNotNull(CommissionManager.getCommissionManager());
    }

}
