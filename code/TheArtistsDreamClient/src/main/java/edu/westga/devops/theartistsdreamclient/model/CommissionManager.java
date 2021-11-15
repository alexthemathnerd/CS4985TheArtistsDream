package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;

/**
 * The commission manager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public abstract class CommissionManager {
    
    private static CommissionManager commissionManager = null;

    public abstract List<Commission> getFirstFiveCommissions(CommissionType type);
    public abstract List<Commission> getNextFiveCommissions(CommissionType type, int startIndex);

    /**
     * Adds a Commission to the Commission manager and returns it's id.
     *
     * @param userId the id of the user wanting the commission
     * @param style the style the user wants the commission done in
     * @param description the description of what the user wants
     * @param budget the budget the user wants to stay in
     * @param title the title of the commission to add
     *
     * @precondition commisison != null 
     * @postcondition none
     * 
     * @return the id of the added commission
     */
    public abstract int addCommission(int userId, Style style, double budget, String description, String title);

    public abstract boolean approveCommission(int id);

    public abstract boolean denyCommission(int id);

    public abstract boolean submitImage(int id, byte[] image);

    public abstract byte[] getSubmission(int id);

    /**
     * Gets the singleton of the commission manager
     *
     * @return the singleton of the commission manager
     * @precondition none
     * @postcondition none
     */
    public static CommissionManager getCommissionManager() {
        return CommissionManager.commissionManager;
    }

    /**
     * Sets the CommissionManager singleton
     *
     * @param commissionManager the new commission manager
     * @preconditon none
     * @postcondition CommissionManager.getCommissionManager().equals(commissionManager)
     */
    public static void setCommissionManager(CommissionManager commissionManager) {
        CommissionManager.commissionManager = commissionManager;
    }
}
