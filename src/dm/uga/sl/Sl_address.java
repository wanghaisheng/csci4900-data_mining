package dm.uga.sl;

/**
 * Student Listings - Address
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

public class Sl_address {
	private int id;
	private String name, room, street_1, street_2, city, state, zip, zip_4, country;
	
	/**
	 * @param name
	 * @param room
	 * @param street_1
	 * @param street_2
	 * @param city
	 * @param state
	 * @param zip
	 * @param zip_4
	 * @param country
	 */
	public Sl_address(String name, String room, String street_1,
			String street_2, String city, String state, String zip,
			String zip_4, String country) {
		this.name = name;
		this.room = room;
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
	 * @param name
	 * @param room
	 * @param street_1
	 * @param street_2
	 * @param city
	 * @param state
	 * @param zip
	 * @param zip_4
	 * @param country
	 */
	public Sl_address(int id, String name, String room, String street_1,
			String street_2, String city, String state, String zip,
			String zip_4, String country) {
		this(name, room, street_1, street_2, city, state, zip, zip_4, country);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the name */
	public String getName() {return name;}
	
	/** @return the room */
	public String getRoom() {return room;}
	
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
