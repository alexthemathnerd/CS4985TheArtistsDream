package edu.westga.devops.theartistsdreamclient.model;

import edu.westga.devops.theartistsdreamclient.utils.UI;

/**
 * Comission class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Commission {
    
    private int userId;

    private Style style;

    private double budget;

    private String description;

    private String title;

    /**
     * Create a new commission
     * 
     * @precondition userId < 0 and userId != nulland style is not null and budget is not null 
     *               and budget greater than zero and and description is not null and description is not empty
     * @postcondition getUserId() == userId and getStyle() == style and getBudget() = budget
     *                getDescription() = description
     * 
     * @param userId the userid of the user wanting the commission
     * @param style the style the user wants the commission done in
     * @param budget the budget the user wants stay in
     * @param description the description of what thw user wants
     * @param title the title of the commission
     */
    public Commission(int userId, Style style, double budget, String description, String title) {
        this.checkPreconditions(userId, style, budget, description, title);
        this.userId = userId;
        this.style = style;
        this.budget = budget;
        this.description = description;
        this.title = title;
    }

    private void checkPreconditions(int userId, Style style, double budget, String description, String title) {
        if (style == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.STYLE_NULL);
        }
        if (description == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.DESCRIPTION_NULL);
        }
        if (title == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.TITLE_NULL);
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.TITLE_EMPTY);
        }
        if (userId < 0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
        }
        if (description.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.DESCRIPTION_EMPTY);
        }
        if (budget <= 0.0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_BUDGET);
        }
    }

    /**
     * Gets the userid of the of the user requesting th commission
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the userId of the user
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Gets the style of the commission
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the style of the commission
     */
    public Style getStyle() {
        return this.style;
    }

    /**
     * Gets the description of the commission
     * 
     * @precondition  none
     * @postcondition none
     *
     * @return the description of the commission
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the budget  of the commisssion
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the budget of the commission
     */
    public double getBudget() {
        return this.budget;
    }

    /**
     * Gets the title of the commission
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return he title of the commission
     */
    public String getTitle() {
        return this.title;
    }
}
