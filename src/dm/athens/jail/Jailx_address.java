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
	private String street_1, street_2, city, state, zip, zip_4, country;
	
	/**
	 * Constructor
	 * @param street_1
	 * @param street_2
	 * @param city
	 * @param state
	 * @param zip
	 * @param zip_4
	 * @param country
	 */
	public Jailx_address(String street_1, String street_2, String city, 
			String state, String zip, String zip_4, String country) {
		this.street_1 = street_1;
		this.street_2 = street_2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.zip_4 = zip_4;
		this.country = country;
	}
	
	/**
	 * Constructor with SQL auto-increment id
	 * @param id
	 * @param street_1
	 * @param street_2
	 * @param city
	 * @param state
	 * @param zip
	 * @param zip_4
	 * @param country
	 */
	public Jailx_address(int id, String street_1, String street_2, String city, 
			String state, String zip, String zip_4, String country) {
		this(street_1, street_2, city, state, zip, zip_4, country);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the street_1 */
	public String getStreet_1() {return street_1;}
	
	/** @return the street_2 */
	public String getStreet_2() {return street_2;}
	
	/** @return the city */
	public String getCity() {return city;}
	
	/** @return the state */
	public String getState() {return state;}
	
	/** @return the zip */
	public String getZip() {return zip;}
	
	/** @return the zip_4 */
	public String getZip_4() {return zip_4;}
	
	/** @return the country */
	public String getCountry() {return country;}
}
