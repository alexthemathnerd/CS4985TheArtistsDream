package edu.westga.devops.theartistsdreamclient.tests.viewmodel.commissiontileviewmodel;

import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.Style;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.CommissionTileViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestConstructor {

    @Mock
    Commission commission;

    @Mock
    UserManager userManager;

    @Test
    void testVaildConstruction() {
        Mockito.when(this.userManager.getUser(0)).thenReturn(new User(0, "test@test.com", "test", "test", new byte[0]));
        UserManager.setUserManager(this.userManager);
        Mockito.when(this.commission.getTitle()).thenReturn("title");
        Mockito.when(this.commission.getUserId()).thenReturn(0);
        Mockito.when(this.commission.getDescription()).thenReturn("text");
        Mockito.when(this.commission.getBudget()).thenReturn(5.0);
        Mockito.when(this.commission.getStyle()).thenReturn(Style.MODERN);

        CommissionTileViewModel result = new CommissionTileViewModel(this.commission);

        assertAll(
                () -> assertEquals("test", result.commissionerProperty().get()),
                () -> assertEquals("title", result.titleProperty().get()),
                () -> assertEquals("$5.00", result.budgetProperty().get()),
                () -> assertEquals(Style.MODERN, result.styleProperty().get()),
                () -> assertEquals("MODERN", result.styleStringProperty().get()),
                () -> assertEquals("text", result.descriptionProperty().get())
        );
    }

}
