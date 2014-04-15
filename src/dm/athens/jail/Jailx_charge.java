package dm.athens.jail;

/**
 * Jail Extended - Charge
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

public class Jailx_charge {
	private int id;
	private String arresting_agency, charge_description, disposition;
	public enum Grade {MISDEMEANOR,FELONY}
	private Grade grade_of_charge;
	
	/**
	 * Constructor
	 * @param arresting_agency
	 * @param grade_of_charge
	 * @param charge_description
	 * @param disposition
	 */
	public Jailx_charge(String arresting_agency, 
			Grade grade_of_charge, String charge_description, String disposition) {
		this.arresting_agency = arresting_agency;
		this.charge_description = charge_description;
		this.disposition = disposition;
		this.grade_of_charge = grade_of_charge;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param arresting_agency
	 * @param grade_of_charge
	 * @param charge_description
	 * @param disposition
	 */
	public Jailx_charge(int id, String arresting_agency, 
			Grade grade_of_charge, String charge_description, String disposition) {
		this(arresting_agency, grade_of_charge, charge_description, disposition);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the arresting_agency */
	public String getArresting_agency() {return arresting_agency;}
	
	/** @return the charge_description */
	public String getCharge_description() {return charge_description;}
	
	/** @return the disposition */
	public String getDisposition() {return disposition;}
	
	/** @return the grade_of_charge */
	public Grade getGrade_of_charge() {return grade_of_charge;}
}