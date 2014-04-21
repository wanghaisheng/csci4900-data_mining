package dm.athens.booking;

/**
 * CVS Tuple strut
 * 
 * @author Vincent Lee
 * @since April 18, 2014
 * @version 1.0
 */

import java.util.Date;

public class BookingCSV {
	private Date booking_date, release_date;
	private String firstname, lastname, year_of_birth, race, sex, arresting_agency, charge, crime_type, court_jurisdiction, 
					bonding_company, warrant_number, police_case_number;
	private double bonding_amount;
	private int mid_number;
	
	/**
	 * CSV Constructor
	 * @param mid_number
	 * @param booking_date
	 * @param firstname
	 * @param lastname
	 * @param year_of_birth
	 * @param race
	 * @param sex
	 * @param arresting_agency
	 * @param release_date
	 * @param charge
	 * @param crime_type
	 * @param court_jurisdiction
	 * @param bonding_company
	 * @param bonding_amount
	 * @param warrant_number
	 * @param police_case_number
	 */
	public BookingCSV(int mid_number, Date booking_date, String firstname,
			String lastname, String year_of_birth, String race, String sex,
			String arresting_agency, Date release_date, String charge,
			String crime_type, String court_jurisdiction,
			String bonding_company, double bonding_amount,
			String warrant_number, String police_case_number) {
		this.mid_number = mid_number;
		this.booking_date = booking_date;
		this.firstname = firstname;
		this.lastname = lastname;
		this.year_of_birth = year_of_birth;
		this.race = race;
		this.sex = sex;
		this.arresting_agency = arresting_agency;
		this.release_date = release_date;
		this.charge = charge;
		this.crime_type = crime_type;
		this.court_jurisdiction = court_jurisdiction;
		this.bonding_company = bonding_company;
		this.bonding_amount = bonding_amount;
		this.warrant_number = warrant_number;
		this.police_case_number = police_case_number;
	}

	/** @return the booking_date */
	public Date getBooking_date() {return booking_date;}

	/** @return the release_date */
	public Date getRelease_date() {return release_date;}

	/** @return the firstname */
	public String getFirstname() {return firstname;}

	/** @return the lastname */
	public String getLastname() {return lastname;}

	/** @return the year_of_birth */
	public String getYear_of_birth() {return year_of_birth;}

	/** @return the race */
	public String getRace() {return race;}

	/** @return the sex */
	public String getSex() {return sex;}

	/** @return the arresting_agency */
	public String getArresting_agency() {return arresting_agency;}

	/** @return the charge */
	public String getCharge() {return charge;}

	/** @return the crime_type */
	public String getCrime_type() {return crime_type;}

	/** @return the court_jurisdiction */
	public String getCourt_jurisdiction() {return court_jurisdiction;}

	/** @return the bonding_company */
	public String getBonding_company() {return bonding_company;}

	/** @return the warrant_number */
	public String getWarrant_number() {return warrant_number;}

	/** @return the police_case_number */
	public String getPolice_case_number() {return police_case_number;}

	/** @return the bonding_amount */
	public double getBonding_amount() {return bonding_amount;}

	/** @return the mid_number */
	public int getMid_number() {return mid_number;}
}

/*
-MID#
-BOOKING TIME
-NAME
-YEAR OF BIRTH
-RACE
-SEX
-ARRESTING AGENCY
-RELEASE TIME
-CHARGE
-CRIME TYPE
-COURT JURISDICTION
-BONDING COMPANY
-BOND AMOUNT
-WARRANT #
-POLICE CASE#
*/