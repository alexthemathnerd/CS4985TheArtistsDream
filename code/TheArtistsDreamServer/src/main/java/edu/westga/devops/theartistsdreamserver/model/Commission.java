package edu.westga.devops.theartistsdreamserver.model;

public class Commission {

    private int id;
    private int artistId;
    private int userId;
    private Style style;
    private double budget;
    private String description;
    private String title;
    private transient boolean isOngoing;

    /**
     * Create a new commission
     *
     * @param id          the id of the commission
     * @param artistId    the artist doing the commission
     * @param userId      the userid of the user wanting the commission
     * @param style       the style the user wants the commission done in
     * @param budget      the budget the user wants stay in
     * @param description the description of what thw user wants
     * @param title       the title of the commission
     * @precondition userId < 0 and userId != nulland style is not null and budget is not null
     * and budget greater than zero and and description is not null and description is not empty
     * @postcondition getUserId() == userId and getStyle() == style and getBudget() = budget
     * getDescription() = description
     */
    public Commission(int id, int artistId, int userId, Style style, double budget, String description, String title) {
        this.checkPreconditions(userId, style, budget, description, title);
        this.id = id;
        this.artistId = artistId;
        this.userId = userId;
        this.style = style;
        this.budget = budget;
        this.description = description;
        this.title = title;
        this.isOngoing = false;
    }

    private void checkPreconditions(int userId, Style style, double budget, String description, String title) {
        if (style == null) {
            throw new IllegalArgumentException();
        }
        if (description == null) {
            throw new IllegalArgumentException();
        }
        if (title == null) {
            throw new IllegalArgumentException();
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (userId < 0) {
            throw new IllegalArgumentException();
        }
        if (description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (budget <= 0.0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOngoing() {
        return this.isOngoing;
    }

    public void setOngoing(boolean ongoing) {
        this.isOngoing = ongoing;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getArtistId() {
        return this.artistId;
    }

}
