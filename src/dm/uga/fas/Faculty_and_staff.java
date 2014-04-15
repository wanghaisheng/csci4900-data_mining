package dm.uga.fas;

/**
 * Faculty and Staff
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Faculty_and_staff {
	private int id;
	private String title, firstname, middlename, lastname, suffix, email;
	private Fas_phone phone;
	private List<Fas_address> address;
	
	/**
	 * No-args Constructor
	 */
	public Faculty_and_staff() {
		address = new ArrayList<Fas_address>();
	}
	
	/**
	 * Constructor
	 * @param title
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param suffix
	 * @param email
	 */
	public Faculty_and_staff(String title, String firstname, String middlename,
			String lastname, String suffix, String email) {
		this();
		this.title = title;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.suffix = suffix;
		this.email = email;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param title
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param suffix
	 * @param email
	 */
	public Faculty_and_staff(int id, String title, String firstname, String middlename,
			String lastname, String suffix, String email) {
		this(title, firstname, middlename, lastname, suffix, email);
		this.id = id;
	}
	
	/**
	 * @param address the address to add
	 * @return true if this collection changed as a result of the call
	 */
	public boolean addAddress(Fas_address address) {return this.address.add(address);}
	
	/** @param phone the phone to set */
	public void setPhone(Fas_phone phone) {this.phone = phone;}
	
	/** @return the address */
	public List<Fas_address> getAddress() {return address;}
	
	/** @return the suffix */
	public String getSuffix() {return suffix;}
	
	/** @return the email */
	public String getEmail() {return email;}
	
	/** @return the phone */
	public Fas_phone getPhone() {return phone;}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the firstname */
	public String getFirstname() {return firstname;}
	
	/** @return the middlename */
	public String getMiddlename() {return middlename;}
	
	/** @return the lastname */
	public String getLastname() {return lastname;}
	
	/** @return the title */
	public String getTitle() {return title;}
}
