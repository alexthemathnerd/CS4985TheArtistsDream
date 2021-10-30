package edu.westga.devops.theartistsdreamclient.model;

/**
 * The commission manager class
 * 
 * @author Jamia Echol
 * @version Fall 2021
 */
public abstract class CommissionManager implements Iterable<Commission> {
    
    private static CommissionManager commissionManager = null;

    /**
     * Adds a Commission to the Commission manager and returns it's id.
     *
     * @param commission the commission to be added
     * 
     * @precondition commisison != null 
     * @postcondition none
     * 
     * @return the id of the added commission
     */
    public abstract int addCommission(Commission commission);

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
     * @preconditon commissionManager != null
     * @postcondition CommissionManager.getCommissionManager().equals(commissionManager)
     */
    public static void setCommissionManager(CommissionManager commissionManager) {
        if (commissionManager == null) {
            throw new IllegalArgumentException();
        }
        CommissionManager.commissionManager = commissionManager;
    }
}
