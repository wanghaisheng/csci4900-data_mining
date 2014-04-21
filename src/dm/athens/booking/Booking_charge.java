package dm.athens.booking;

/**
 * Jail Booking Recap Report - Charge
 * 
 * @author Vincent Lee
 * @since April 18, 2014
 * @version 1.0
 */

import java.util.Date;

public class Booking_charge {
	private Date booking_date, release_date;
	private String arresting_agency, grade_of_charge, charge_description, court_jurisdiction, 
					bonding_company, disposition, warrant_number, police_case_number;
	private double bonding_amount;
	
	/**
	 * Constsructor
	 * @param booking_date
	 * @param release_date
	 * @param arresting_agency
	 * @param grade_of_charge
	 * @param charge_description
	 * @param court_jurisdiction
	 * @param bonding_company
	 * @param bonding_amount
	 * @param disposition
	 * @param warrant_number
	 * @param police_case_number
	 */
	public Booking_charge(Date booking_date, Date release_date,
			String arresting_agency, String grade_of_charge,
			String charge_description, String court_jurisdiction, String bonding_company,
			double bonding_amount, String disposition, String warrant_number,
			String police_case_number) {
		this.booking_date = booking_date;
		this.release_date = release_date;
		this.arresting_agency = arresting_agency;
		this.grade_of_charge = grade_of_charge;
		this.charge_description = charge_description;
		this.court_jurisdiction = court_jurisdiction;
		this.bonding_company = bonding_company;
		this.bonding_amount = bonding_amount;
		this.disposition = disposition;
		this.warrant_number = warrant_number;
		this.police_case_number = police_case_number;
	}

	/** @return the booking_date */
	public Date getBooking_date() {return booking_date;}

	/** @return the release_date */
	public Date getRelease_date() {return release_date;}

	/** @return the arresting_agency */
	public String getArresting_agency() {return arresting_agency;}

	/** @return the grade_of_charge */
	public String getGrade_of_charge() {return grade_of_charge;}

	/** @return the charge_description */
	public String getCharge_description() {return charge_description;}

	/** @return the court_jurisdiction */
	public String getCourt_jurisdiction() {return court_jurisdiction;}

	/** @return the bonding_company */
	public String getBonding_company() {return bonding_company;}

	/** @return the disposition */
	public String getDisposition() {return disposition;}

	/** @return the warrant_number */
	public String getWarrant_number() {return warrant_number;}

	/** @return the police_case_number */
	public String getPolice_case_number() {return police_case_number;}

	/** @return the bonding_amount */
	public double getBonding_amount() {return bonding_amount;}
}