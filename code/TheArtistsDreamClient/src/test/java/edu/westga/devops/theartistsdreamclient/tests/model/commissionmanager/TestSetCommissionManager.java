package edu.westga.devops.theartistsdreamclient.tests.model.commissionmanager;

import edu.westga.devops.theartistsdreamclient.model.CommissionManager;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TestSetCommissionManager {

    @Mock
    CommissionManager commissionManager;

    @Test
    void setToNewCommissionManager() {
        CommissionManager.setCommissionManager(this.commissionManager);
        assertNotNull(CommissionManager.getCommissionManager());
    }

}
