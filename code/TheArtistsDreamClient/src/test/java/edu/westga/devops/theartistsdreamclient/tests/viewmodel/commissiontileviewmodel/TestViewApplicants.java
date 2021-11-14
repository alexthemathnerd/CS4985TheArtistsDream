package edu.westga.devops.theartistsdreamclient.tests.viewmodel.commissiontileviewmodel;

import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.Style;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.CommissionTileViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class TestViewApplicants {

    @Mock
    Commission commission;

    @Mock
    UserManager userManager;

    @BeforeEach
    private void init() {
        UserManager.setUserManager(this.userManager);
        Mockito.when(this.userManager.getUser(0)).thenReturn(new User(0, "test@test.com", "test", "test", new byte[0]));
        Mockito.when(this.commission.getStyle()).thenReturn(Style.MODERN);
    }

    @Test
    void testApply() {
        CommissionTileViewModel viewModel = new CommissionTileViewModel(this.commission);
        viewModel.viewApplicants();
    }

    @AfterEach
    private void finish() {
        UserManager.setUserManager(null);
    }

}
