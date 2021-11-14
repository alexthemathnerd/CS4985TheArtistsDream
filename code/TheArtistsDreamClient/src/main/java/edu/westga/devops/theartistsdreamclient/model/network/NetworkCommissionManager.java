package edu.westga.devops.theartistsdreamclient.model.network;

import com.google.gson.reflect.TypeToken;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.CommissionManager;
import edu.westga.devops.theartistsdreamclient.model.CommissionType;
import edu.westga.devops.theartistsdreamclient.model.Style;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NetworkCommissionManager extends CommissionManager {

    private Communicator communicator;

    public NetworkCommissionManager() {
        this.communicator = new Communicator("tcp://localhost:4444");
    }

    public NetworkCommissionManager(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public List<Commission> getFirstFiveCommissions(CommissionType commissionType) {
        Type type = new TypeToken<Response<ArrayList<Commission>>>() {
        }.getType();
        Response<ArrayList<Commission>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FIRST_FIVE_COMMISSIONS, new Object[]{commissionType, User.getUser().getUserId()}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override
    public List<Commission> getNextFiveCommissions(CommissionType commissionType, int startIndex) {
        Type type = new TypeToken<Response<ArrayList<Commission>>>() {
        }.getType();
        Response<ArrayList<Commission>> response = this.communicator.request(new Request(UI.ServerCodes.GET_NEXT_FIVE_COMMISSIONS, new Object[]{commissionType, startIndex}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override
    public int addCommission(int userId, Style style, double budget, String description, String title) {
        Type type = new TypeToken<Response<Boolean>>() {
        }.getType();
        Response<Integer> response = this.communicator.request(new Request(UI.ServerCodes.ADD_COMMISSION, new Object[]{userId, User.getUser().getUserId(), style, budget, description, title}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return -1;
        }
        return response.getData();
    }

}
