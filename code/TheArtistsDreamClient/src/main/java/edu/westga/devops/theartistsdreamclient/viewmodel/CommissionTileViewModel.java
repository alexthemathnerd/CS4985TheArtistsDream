package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.Style;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

import java.text.NumberFormat;

import java.util.Locale;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * CommissionTile ViewModel
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class CommissionTileViewModel {

	private StringProperty titleProperty;
	private StringProperty commissionerProperty;
	private StringProperty descriptionProperty;
	private StringProperty budgetProperty;
	private ObjectProperty<Style> styleProperty;

	/**
	 * Creates a new CommissionTileViewModel of the specified commission
	 *
	 * @param commission the commission
	 *
	 * @precondition none
	 * @postcondition titleProperty().get().equals(commission.getTitle()) && commissionerProperty().get().equals(UserManager.getUser(commission.getUserId().getUsername())) && descriptionProperty().equals(commission.getDescription()) && budgetProperty().get().equals(commission.getBudget()) && styleProperty().get() == commission.getStyle()
	 */
	public CommissionTileViewModel(Commission commission) {
		this.titleProperty = new SimpleStringProperty(commission.getTitle());
		this.commissionerProperty = new SimpleStringProperty(UserManager.getUserManager().getUser(commission.getUserId()).getUsername());
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
		this.descriptionProperty = new SimpleStringProperty(commission.getDescription());
		this.budgetProperty = new SimpleStringProperty(currencyFormatter.format(commission.getBudget()));
		this.styleProperty = new SimpleObjectProperty<Style>(commission.getStyle());
	}

	/**
	 * Gets the title property
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the title property
	 */
	public StringProperty titleProperty() {
		return this.titleProperty;
	}

	/**
	 * Gets the commissioner property
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the commissioner property
	 */
	public StringProperty commissionerProperty() {
		return this.commissionerProperty;
	}

	/**
	 * Gets the description property
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the description property
	 */
	public StringProperty descriptionProperty() {
		return this.descriptionProperty;
	}

	/**
	 * Gets the budget property
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the budget property
	 */
	public StringProperty budgetProperty() {
		return this.budgetProperty;
	}

	/**
	 * Gets the style property
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the style property
	 */
	public ObjectProperty<Style> styleProperty() {
		return this.styleProperty;
	}

	public void apply() {

	}

	public void viewApplicants() {

	}

}
