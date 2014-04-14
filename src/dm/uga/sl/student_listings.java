package dm.uga.sl;

/**
 * Student Listings
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class student_listings {
	private int id;
	private String firstname, middlename, lastname, email, year_start, year_end;
	private List<sl_phone> phone;
	private List<sl_address> address;
	
	/**
	 * No-args Constructor
	 */
	public student_listings() {
		phone = new ArrayList<sl_phone>();
		address = new ArrayList<sl_address>();
	}
	
	/**
	 * Constructor
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param email
	 * @param year_start
	 * @param year_end
	 */
	public student_listings(String firstname, String middlename,
			String lastname, String email, String year_start, String year_end) {
		this();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.email = email;
		this.year_start = year_start;
		this.year_end = year_end;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param email
	 * @param year_start
	 * @param year_end
	 */
	public student_listings(int id, String firstname, String middlename,
			String lastname, String email, String year_start, String year_end) {
		this(firstname, middlename, lastname, email, year_start, year_end);
		this.id = id;
	}
	
	/**
	 * @param phone the phone to add
	 * @return true if this collection changed as a result of the call
	 */
	public boolean addPhone(sl_phone phone) {
		return this.phone.add(phone);
	}
	
	/**
	 * @param address the address to add
	 * @return true if this collection changed as a result of the call
	 */
	public boolean addAddress(sl_address address) {
		return this.address.add(address);
	}
	
	/** @return the phone */
	public List<sl_phone> getPhone() {return phone;}
	
	/** @return the address */
	public List<sl_address> getAddress() {return address;}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the firstname */
	public String getFirstname() {return firstname;}
	
	/** @return the middlename */
	public String getMiddlename() {return middlename;}
	
	/** @return the lastname */
	public String getLastname() {return lastname;}
	
	/** @return the email */
	public String getEmail() {return email;}
	
	/** @return the year_start */
	public String getYear_start() {return year_start;}
	
	/** @return the year_end */
	public String getYear_end() {return year_end;}
}
