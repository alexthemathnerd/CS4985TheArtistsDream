package edu.westga.devops.theartistsdreamclient.tests.viewmodel.headerviewmodel;

import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.HeaderViewModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestGetUser {

    @Mock
    private UserManager userManager;

    @Test
    void testSuccessfulCall() {
        UserManager.setUserManager(this.userManager);
        HeaderViewModel test = new HeaderViewModel();
        test.getUser("");
        Mockito.verify(this.userManager).retrieveSearchedUser("");
    }

}
