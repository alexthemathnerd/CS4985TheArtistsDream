package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import java.util.List;
import java.util.stream.Collectors;

public class CommissionManager {

    public static Request getFirstFiveCommissions(Object[] data) {
        CommissionType type;
        int userId;
        try {
            type = CommissionType.valueOf((String) data[0]);
            userId = ((Double) data[1]).intValue();
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return new Request(e.getMessage());
        }
        switch (type) {
            case OPEN:
                return getOpenCommissions();
            case DIRECT:
                return getDirectCommissions(userId);
            case ONGOING:
                return getOngoingCommissions(userId);
            default:
                return new Request("No valid type");
        }
    }

    private static Request getOpenCommissions() {
        List<Commission> commissions = TheArtistsDreamServer.COMMISSIONS.stream().filter((commission) -> {
            return commission.getArtistId() == -1;
        }).collect(Collectors.toList());
        if (commissions.size() < 50) {
            return new Request(commissions);
        }
        return new Request(commissions.subList(0, 50));
    }

    private static Request getDirectCommissions(int userId) {
        List<Commission> commissions = TheArtistsDreamServer.COMMISSIONS.stream().filter((commission) -> {
            return commission.getArtistId() == userId && !commission.isOngoing();
        }).collect(Collectors.toList());
        if (commissions.size() < 5) {
            return new Request(commissions);
        }
        return new Request(commissions.subList(0, 5));
    }

    private static Request getOngoingCommissions(int userId) {
        List<Commission> commissions = TheArtistsDreamServer.COMMISSIONS.stream().filter((commission) -> {
            return (commission.getArtistId() == userId || commission.getUserId() == userId) && commission.isOngoing();
        }).collect(Collectors.toList());
        if (commissions.size() < 5) {
            return new Request(commissions);
        }
        return new Request(commissions.subList(0, 5));
    }

    public static Request approveCommission(Object[] data) {
        int id;
        Commission commission;
        try {
            id = ((Double) data[0]).intValue();
            commission = TheArtistsDreamServer.COMMISSIONS.get(id);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return new Request(e.getMessage());
        }
        commission.setOngoing(true);
        return new Request(true);
    }

    public static Request denyCommission(Object[] data) {
        int id;
        Commission commission;
        try {
            id = ((Double) data[0]).intValue();
            commission = TheArtistsDreamServer.COMMISSIONS.get(id);
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            return new Request(e.getMessage());
        }
        return new Request(TheArtistsDreamServer.COMMISSIONS.remove(commission));
    }

    public static Request addCommission(Object[] data) {
        int artistId;
        int userId;
        Style style;
        double budget;
        String description;
        String title;
        try {
            artistId = ((Double) data[0]).intValue();
            userId = ((Double) data[1]).intValue();
            style = Style.valueOf((String) data[2]);
            budget = (Double) data[3];
            description = (String) data[4];
            title = (String) data[5];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return new Request(e.getMessage());
        }
        TheArtistsDreamServer.COMMISSIONS.add(new Commission(TheArtistsDreamServer.COMMISSIONS.size(), artistId, userId, style, budget, description, title));
        return new Request(TheArtistsDreamServer.COMMISSIONS.size() - 1);
    }

}
