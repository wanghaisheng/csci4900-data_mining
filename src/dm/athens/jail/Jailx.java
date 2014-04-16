package dm.athens.jail;

/**
 * Jail Extended - CURRENT PRISONER LISTING
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jailx extends Jail {
	private Date released_date;
	private int height, weight;
	private boolean photo;
	
	private Jailx_address address;
	private List<Jailx_charge> charges;
	
	/**
	 * Constructor
	 * @param mid_number
	 * @param firstname
	 * @param lastname
	 * @param sex
	 * @param race
	 * @param year_of_birth
	 * @param height
	 * @param weight
	 * @param booking_date
	 * @param released_date
	 * @param bond_amount
	 * @param case_number
	 * @param police_case_number
	 * @param visitation
	 * @param photo
	 */
	public Jailx(int mid_number, String firstname, String lastname, String sex,
			String race, String year_of_birth, int height, int weight, 
			Date booking_date, Date released_date, double bond_amount, String case_number, 
			String police_case_number, String visitation, boolean photo) {
		super(mid_number, firstname, lastname, sex, race, booking_date, null, bond_amount, case_number, police_case_number, year_of_birth, visitation);
		this.released_date = released_date;
		this.height = height;
		this.weight = weight;
		this.photo = photo;
		this.charges = new ArrayList<Jailx_charge>();
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param mid_number
	 * @param firstname
	 * @param lastname
	 * @param sex
	 * @param race
	 * @param year_of_birth
	 * @param height
	 * @param weight
	 * @param booking_date
	 * @param released_date
	 * @param bond_amount
	 * @param case_number
	 * @param police_case_number
	 * @param visitation
	 * @param photo
	 */
	public Jailx(int id, int mid_number, String firstname, String lastname, String sex,
			String race, String year_of_birth, int height, int weight, 
			Date booking_date, Date released_date, double bond_amount, String case_number, 
			String police_case_number, String visitation, boolean photo) {
		super(id, mid_number, firstname, lastname, sex, race, booking_date, null, bond_amount, case_number, police_case_number, year_of_birth, visitation);
		this.released_date = released_date;
		this.height = height;
		this.weight = weight;
		this.photo = photo;
		this.charges = new ArrayList<Jailx_charge>();
	}
	
	/**
	 * @param charge the charges to add
	 * @return true if this collection changed as a result of the call
	 */
	public boolean addAllCharges(List<Jailx_charge> charges) {return this.charges.addAll(charges);}
	
	/** @param address the address to set */
	public void setAddress(Jailx_address address) {this.address = address;}
	
	/** @return the released_date */
	public Date getReleased_date() {return released_date;}
	
	/** @return the height */
	public int getHeight() {return height;}
	
	/** @return the weight */
	public int getWeight() {return weight;}
	
	/** @return the photo */
	public boolean isPhoto() {return photo;}
	
	/** @return the address */
	public Jailx_address getAddress() {return address;}
	
	/** @return the charges */
	public List<Jailx_charge> getCharges() {return charges;}
	
	/**
	 * @return toString
	 */
	public String toString() {
		return super.toString() + " Jailx [released_date=" + released_date + ", height=" + height
				+ ", weight=" + weight + ", photo=" + photo + ", address="
				+ address + ", charges=" + charges + "]";
	}
}