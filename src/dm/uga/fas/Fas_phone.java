package dm.uga.fas;

/**
 * Faculty and Staff - Phone Number
 * 
 * @author Vincent Lee
 * @since April 8, 2014
 * @version 1.0
 */

public class Fas_phone {
	private int id;
	private String country_code, area_code, exchange_code, line_number, extension;
	
	/**
	 * @param country_code
	 * @param area_code
	 * @param exchange_code
	 * @param line_number
	 * @param extension
	 */
	public Fas_phone(String country_code, String area_code,
			String exchange_code, String line_number, String extension) {
		this.country_code = country_code;
		this.area_code = area_code;
		this.exchange_code = exchange_code;
		this.line_number = line_number;
		this.extension = extension;
	}
	
	/**
	 * @param id
	 * @param country_code
	 * @param area_code
	 * @param exchange_code
	 * @param line_number
	 * @param extension
	 */
	public Fas_phone(int id, String country_code, String area_code,
			String exchange_code, String line_number, String extension) {
		this(country_code, area_code, exchange_code, line_number, extension);
		this.id = id;
	}
	
	/** @return the id */
	public int getId() {return id;}
	
	/** @return the country_code */
	public String getCountry_code() {return country_code;}
	
	/** @return the area_code */
	public String getArea_code() {return area_code;}
	
	/** @return the exchange_code */
	public String getExchange_code() {return exchange_code;}
	
	/** @return the line_number */
	public String getLine_number() {return line_number;}
	
	/** @return the extension */
	public String getExtension() {return extension;}
}
