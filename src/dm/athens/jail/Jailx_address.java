package dm.athens.jail;

/**
 * Jail Extended - Address
 * 
 * @author Vincent Lee
 * @since April 14, 2014
 * @version 1.0
 */

public class Jailx_address {
	private int id;
	private String street, city, state, zip;
	
	/**
	 * Constructor
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Jailx_address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Jailx_address(int id, String street, String city, String state, String zip) {
		this(street, city, state, zip);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the street */
	public String getStreet() {return street;}
	
	/** @return the city */
	public String getCity() {return city;}
	
	/** @return the state */
	public String getState() {return state;}
	
	/** @return the zip */
	public String getZip() {return zip;}
	
	/**
	 * @return toString
	 */
	public String toString() {
		return "Jailx_address [id=" + id + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zip=" + zip + "]";
	}
}
