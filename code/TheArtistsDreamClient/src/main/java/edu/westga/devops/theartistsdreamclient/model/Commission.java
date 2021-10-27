package edu.westga.devops.theartistsdreamclient.model;

import edu.westga.devops.theartistsdreamclient.utils.UI;

/**
 * Comission class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Commission {
    
    private String name;

    private String style;

    private double budget;

    private String size;

    private String description;

    /**
     * Create a new commission
     * 
     * @precondition name != null && name is not empty and style is not null and style is not empty and 
     *              budget is not null and budget greater than zero and size is not null and size is not empty and
     *              and description is not null and description is not empty
     * @postcondition getName() == name and getStyle() == style and getBudget() = budget and getSize() == size
     *                getDescription() = description
     * 
     * @param name the name of the user requesting the commission
     * @param style the style the user wants the commission done in
     * @param budget the budget the user wants stay in
     * @param size the size of the are piece
     * @param description the description of what thw user wants
     */
    public Commission(String name, String style, double budget, String size, String description) {
        this.checkPreconditions(name, style, budget, size, description);
        this.name = name;
        this.style = style;
        this.budget = budget;
        this.size = size;
        this.description = description;
    }

    private void checkPreconditions(String name, String style, double budget, String size, String description) {
        if (name == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.NAME_NULL);
        }
        if (style == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.NAME_EMPTY);
        }
        if (size == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.SIZE_NULL);
        }
        if (description == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.DESCRIPTION_NULL);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.NAME_EMPTY);
        }
        if (description.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.DESCRIPTION_EMPTY);
        }
        if (budget <= 0.0) {
            throw new IllegalArgumentException(UI.ErrorMessages.BUDGET_NOT_POSITIVE);
        }
        if (style.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.STYLE_EMPTY);
        }
    }

    /**
     * Gets the name of the of the user requesting th commission
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the style of the commission
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the style of the commission
     */
    public String getStyle() {
        return this.style;
    }

    /**
     * Gets the size of the commission
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the size of the commission
     */
    public String getSize() {
        return this.size;
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
}
