package dm.athens.booking;

/**
 * Jail Booking Recap Report - Address
 * 
 * @author Vincent Lee
 * @since April 18, 2014
 * @version 1.0
 */

public class Booking_address {
	private String street, city, state, zip;
	
	/**
	 * Constructor
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Booking_address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/** @return the street */
	public String getStreet() {return street;}
	
	/** @return the city */
	public String getCity() {return city;}
	
	/** @return the state */
	public String getState() {return state;}
	
	/** @return the zip */
	public String getZip() {return zip;}
}
